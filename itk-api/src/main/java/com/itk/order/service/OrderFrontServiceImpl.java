package com.itk.order.service;

import com.itk.base.service.ShopInfoService;
import com.itk.exception.ObjectNotFoundException;
import com.itk.exception.SystemException;
import com.itk.item.mapper.ItemInfoMapper;
import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoService;
import com.itk.order.model.OrderDetail;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderInfoVO;
import com.itk.order.model.ShoppingCartVO;
import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoService;
import com.itk.user.service.UserShippingAddressService;
import com.itk.utils.OrderIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class OrderFrontServiceImpl {

    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    UserShippingAddressService userShippingAddressService;

    @Autowired
    ShopInfoService shopInfoService;

    @Autowired
    ItemInfoService itemInfoService;

    @Autowired
    SaleInfoService saleInfoService;

    public int addOrderHeader(OrderHeader orderHeader) {
        orderHeader.setCreateTime(new Date());
        return orderHeaderService.addOrderHeader(orderHeader);
    }

    public int delOrderHeader(Long id) {
        return orderHeaderService.delOrderHeader(id);
    }

    public int updateOrderHeader(OrderHeader orderHeader) {
        return orderHeaderService.updateOrderHeader(orderHeader);
    }

    public OrderHeader selectByOrderId(String orderId) {
        return orderHeaderService.selectByOrderId(orderId);
    }

    public ShoppingCartVO getOrderInfoVoDetail(ShoppingCartVO shoppingCartVO) {
        ShoppingCartVO.ReceiveInfo receiveInfo = new ShoppingCartVO.ReceiveInfo();
        receiveInfo.setUserShippingAddress(userShippingAddressService.selectByPrimaryKey(shoppingCartVO.getAddressId()));
        List<ShoppingCartVO.ShopDetail> shopDetailList = shoppingCartVO.getShopList();
        shopDetailList.stream().map(shopDetail -> {
            shopDetail.setShop(shopInfoService.selectByPrimaryKey(shopDetail.getShopId()));
            shopDetail.getProducts().stream().map(productDetail -> {
                productDetail.setItemInfo(ItemInfoMapper.modelToVO(itemInfoService.selectByPrimaryKey(productDetail.getItemId())));
                return productDetail;
            });
            // 店铺优惠券扣减
            if (shopDetail.getCoupon() != null) {
                // TODO: 6/12/17 not Null 商品过期 平台优惠券
                SaleInfo saleInfo = saleInfoService.selectByPrimaryKey(shopDetail.getCoupon().getId());
                shopDetail.setCoupon(saleInfo);
                if (saleInfo == null) {
                    throw new ObjectNotFoundException(SaleInfo.class, shopDetail.getCoupon().getId());
                }
                //店铺货物加起来的减免之前的金额
                BigDecimal totalMarket = shopDetail.getProducts().stream().map(productDetail -> {
                    return productDetail.getItemInfo().getPrice().multiply(new BigDecimal(productDetail.getNumber()));
                }).reduce(BigDecimal.ZERO, BigDecimal::add);

                //优惠券的可用,
                // 并且有效日期在当前日期之后
                //saleType（1：满减 2：现金券）
                // (saleType == 1 即为满减 && 如果店铺中商品价格加起来不小于满减,才可以使用券) || (现金券)
                if ((saleInfo.getIsDel() == 0) &&
                        saleInfo.getEffectiveDate().after(new Date()) &&
                        (((1 == saleInfo.getSaleType()) && (totalMarket.compareTo(saleInfo.getSaleAmount()) > -1)) || (2 == saleInfo.getSaleType()))) {
                    for (int i = 0; i < shopDetail.getProducts().size(); i++) {
                        BigDecimal shopDiscountAmount = BigDecimal.ZERO;//商家券每次扣减金额的和
                        shopDetail.getProducts().get(i).getPrice().setMarket(shopDetail.getProducts().get(i).getItemInfo().getPrice().multiply(new BigDecimal(shopDetail.getProducts().get(i).getNumber())));
                        //最后一个商品,扣减的券的金额是 券总额 减去前面用掉的券的和
                        if (i != shopDetail.getProducts().size() - 1) {
                            //该商品需要减扣的金额(券金额按照商品金额的权重分配减免金额)
                            BigDecimal temp = shopDetail.getProducts().get(i).getItemInfo().getPrice().divide(totalMarket, 2, BigDecimal.ROUND_DOWN).multiply(saleInfo.getAmount());
                            shopDetail.getProducts().get(i).getPrice().setActual(shopDetail.getProducts().get(i).getItemInfo().getPrice().multiply(new BigDecimal(shopDetail.getProducts().get(i).getNumber())).subtract(temp));
                            shopDiscountAmount = shopDiscountAmount.add(temp);
                        } else {
                            BigDecimal lastShopDiscountAmount = saleInfo.getAmount().subtract(shopDiscountAmount);
                            shopDetail.getProducts().get(i).getPrice().setActual(shopDetail.getProducts().get(i).getItemInfo().getPrice().multiply(new BigDecimal(shopDetail.getProducts().get(i).getNumber())).subtract(lastShopDiscountAmount));
                        }
                    }
                } else {
                    //无可使用的券,actual price 不减扣券金额, 直接使用 单价 * 数量
                    shopDetail.getProducts().stream().map(productDetail -> {
                        productDetail.getPrice().setMarket(productDetail.getItemInfo().getPrice().multiply(new BigDecimal(productDetail.getNumber())));
                        productDetail.getPrice().setActual(productDetail.getItemInfo().getPrice().multiply(new BigDecimal(productDetail.getNumber())));
                        return productDetail;
                    });
                }
            } else {
                //无可使用的店铺券,actual price 不减扣券金额, 直接使用 单价 * 数量
                shopDetail.getProducts().stream().map(productDetail -> {
                    productDetail.getPrice().setMarket(productDetail.getItemInfo().getPrice().multiply(new BigDecimal(productDetail.getNumber())));
                    productDetail.getPrice().setActual(productDetail.getItemInfo().getPrice().multiply(new BigDecimal(productDetail.getNumber())));
                    return productDetail;
                });
            }

            //计算购物车总金额
            shopDetail.setMarketTotal(shopDetail.getProducts().stream().map(productDetail -> {
                return productDetail.getPrice().getMarket();
            }).reduce(BigDecimal.ZERO, BigDecimal::add));
            //计算购物车实际总金额
            shopDetail.setActualTotal(shopDetail.getProducts().stream().map(productDetail -> {
                return productDetail.getPrice().getActual();
            }).reduce(BigDecimal.ZERO, BigDecimal::add));
            return shopDetail;
        }).collect(Collectors.toList());

        shoppingCartVO.setShopList(shopDetailList);
        return shoppingCartVO;
    }

    @Transactional
    public OrderInfoVO getPurchaseOrderDetail(OrderInfoVO orderInfoVO) {

        //平台优惠券
        SaleInfo platformSaleInfo = null;
        //平台优惠券金额
        BigDecimal platformSaleInfoAmount = BigDecimal.ZERO;
        //平台优惠券每次减扣的金额的和
        BigDecimal platformDiscountAmount = BigDecimal.ZERO;
        //平台优惠券最后一次券的抵扣金额（平台券总额 - 前面所有抵扣金额的和）
        BigDecimal lastPlatformDiscountAmount = BigDecimal.ZERO;
        if (orderInfoVO.getPlatformCouponId() != null) {
            SaleInfo temp = saleInfoService.selectByPrimaryKey(orderInfoVO.getPlatformCouponId());
            //判断券的过期时间
            if (temp != null && temp.getInvalidDate().after(new Date())) {
                platformSaleInfo = temp;
                platformSaleInfoAmount = platformSaleInfo.getAmount();
            }
        }

        //所有商品的总价 （平台优惠券算权重要用到）,不算运费
        BigDecimal totalProductAmount = BigDecimal.ZERO;
        //计算所有商品的总价
        for (int i = 0; i < orderInfoVO.getOrderList().size(); i++) {
            List<OrderInfoVO.Product> products = orderInfoVO.getOrderList().get(i).getProducts();
            for (int j = 0; j < products.size(); j++) {
                ItemInfo tempItemInfo = itemInfoService.selectByPrimaryKey(products.get(j).getItemId());
                totalProductAmount = totalProductAmount.add(tempItemInfo.getPrice().multiply(new BigDecimal(products.get(j).getNumber())));
            }
        }

        List<OrderInfoVO.OrderShopDetail> orderList = orderInfoVO.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            OrderInfoVO.OrderShopDetail order = orderList.get(i);
            OrderHeader orderHeader = new OrderHeader();
            orderHeader.setOrderId(OrderIdUtil.orderIDGenerator());
            orderHeader.setStatus(1);
            orderHeader.setAddressId(orderInfoVO.getAddressId());
            orderHeader.setShopId(order.getShopId());
            orderHeader.setAllocationType(orderInfoVO.getAllocationType());

            //配送方式(0: 平台配送, 1: 用户自提)
            if (0 == orderHeader.getAllocationType()) {
                //orderHeader.setAllocationFromTime();
                //orderHeader.setAllocationToTime();
                //orderHeader.setArrivalTime();
                //orderHeader.setCompleteTime();
            } else {
                if (orderInfoVO.getPickSelfLocationId() == null) {
                    throw new SystemException(2001);
                }
                orderHeader.setPickSelfLocationId(orderInfoVO.getPickSelfLocationId());
            }


            //店铺优惠券
            SaleInfo shopSaleInfo = null;
            //商家券优惠金额
            BigDecimal shopSaleInfoAmount = BigDecimal.ZERO;
            //商家券每次减扣的金额的和
            BigDecimal shopDiscountAmount = BigDecimal.ZERO;
            //商家券最后一次券的抵扣金额（券总额 - 前面所有抵扣金额的和）
            BigDecimal lastShopDiscountAmount = BigDecimal.ZERO;
            if (order.getCouponId() != null) {
                SaleInfo temp = saleInfoService.selectByPrimaryKey(order.getCouponId());
                //判断券的过期时间
                if (temp != null && temp.getInvalidDate().after(new Date())) {
                    shopSaleInfo = temp;
                    shopSaleInfoAmount = shopSaleInfo.getAmount();
                }
            }
            order.setSaleInfo(shopSaleInfo);

            //单个订单的总价(不算运费)
            BigDecimal orderTotalAmount = BigDecimal.ZERO;
            //单个订单的实际支付金额
            BigDecimal orderActualAmount = BigDecimal.ZERO;
            //装载 itemInfo ,计算出单个订单的总价
            for (int j = 0; j < order.getProducts().size(); j++) {
                ItemInfo itemInfo = itemInfoService.selectByPrimaryKey(order.getProducts().get(j).getItemId());
                order.getProducts().get(j).setItemInfo(itemInfo);
                orderTotalAmount = orderTotalAmount.add(itemInfo.getPrice().multiply(new BigDecimal(order.getProducts().get(j).getNumber())));
            }

            for (int j = 0; j < order.getProducts().size(); j++) {
                OrderInfoVO.Product product = order.getProducts().get(j);
                OrderDetail orderDetail = new OrderDetail();
                ItemInfo itemInfo = product.getItemInfo();
                orderDetail.setOrderId(orderHeader.getOrderId());
                orderDetail.setItemInfoId(itemInfo.getItemId());
                orderDetail.setItemCount(product.getNumber());
                // TODO: 6/14/17  运费 ID      计算价格的时候需要考虑
                //orderDetail.setFreightId();

                //商家券减扣
                //type 1：全场券（平台） 2：商家券（商家）  3：会员全场券(平台) 4：会员商家券（商家）
                //saleType（1：满减 2：现金券）
                //(如果有券) && 商家券 && ((满减券 && 订单总金额满足满减) || 现金券)
                if (order.getCouponId() != null && shopSaleInfo != null && shopSaleInfo.getType() == 2 &&
                        ((shopSaleInfo.getSaleType() == 1 && orderTotalAmount.compareTo(shopSaleInfo.getSaleAmount()) > -1) ||
                                shopSaleInfo.getSaleType() == 2)) {
                    orderDetail.setShopPromotionCode(order.getCouponId());
                    //最后一件商品,减扣金额为 券总额 - 前面已减扣的金额的和
                    if (j != order.getProducts().size() - 1) {
                        //该商品需要减扣的金额(券金额按照商品金额的权重分配减免金额)
                        BigDecimal temp = itemInfo.getPrice().multiply(new BigDecimal(product.getNumber())).divide(orderTotalAmount, 2, BigDecimal.ROUND_DOWN).multiply(shopSaleInfoAmount);
                        shopDiscountAmount = shopSaleInfoAmount.add(temp);
                        orderDetail.setShopPromotionCost(temp);
                    } else {
                        lastShopDiscountAmount = shopSaleInfoAmount.subtract(shopDiscountAmount);
                        orderDetail.setShopPromotionCost(lastShopDiscountAmount);
                    }
                }

                //平台券减扣
                //type 1：全场券（平台） 2：商家券（商家）  3：会员全场券(平台) 4：会员商家券（商家）
                //saleType（1：满减 2：现金券）
                //(如果有券) && 平台券 && ((满减券 && 订单总金额满足满减) || 现金券)
                if (orderInfoVO.getPlatformCouponId() != null && platformSaleInfo != null && platformSaleInfo.getType() == 1 &&
                        ((platformSaleInfo.getSaleType() == 1 && totalProductAmount.compareTo(platformSaleInfo.getSaleAmount()) > -1) ||
                                platformSaleInfo.getSaleType() == 2)) {
                    orderDetail.setPlatformPromotionCode(orderInfoVO.getPlatformCouponId());
                    if (j != order.getProducts().size() - 1) {
                        BigDecimal temp = itemInfo.getPrice().divide(totalProductAmount,2,BigDecimal.ROUND_DOWN).multiply(platformSaleInfoAmount);
                        platformDiscountAmount = platformDiscountAmount.add(temp);
                        orderDetail.setPlatformPromotionCost(temp);
                    }else{
                        lastPlatformDiscountAmount = platformSaleInfoAmount.subtract(platformDiscountAmount);
                        orderDetail.setPlatformPromotionCost(lastPlatformDiscountAmount);
                    }
                }
                orderDetailService.addOrderDetail(orderDetail);

                BigDecimal productActual = product.getItemInfo().getPrice().multiply(new BigDecimal(product.getNumber()));
                if(orderDetail.getPlatformPromotionCost() != null){
                    productActual = productActual.subtract(orderDetail.getPlatformPromotionCost());
                }
                if(orderDetail.getShopPromotionCost() != null){
                    productActual = productActual.subtract(orderDetail.getShopPromotionCost());
                }
                orderActualAmount = orderActualAmount.add(productActual.compareTo(BigDecimal.ZERO) > -1 ? productActual:BigDecimal.ZERO);
            }

            // TODO: 6/15/17 总金额,实际支付金额, 需要考虑运费
            orderHeader.setTotalAmount(orderTotalAmount);
            orderHeader.setActualAmount(orderActualAmount);
            this.addOrderHeader(orderHeader);
        }

        return orderInfoVO;
    }


}
