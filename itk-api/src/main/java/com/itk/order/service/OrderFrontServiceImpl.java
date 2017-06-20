package com.itk.order.service;

import com.itk.base.model.ShopInfo;
import com.itk.base.service.ShopInfoService;
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
        shoppingCartVO.setReceiveInfo(receiveInfo);

        //平台优惠券
        SaleInfo platformSaleInfo = null;
        //平台优惠券金额
        BigDecimal platformSaleInfoAmount = BigDecimal.ZERO;
        //平台优惠券每次减扣的金额的和
        BigDecimal platformDiscountAmount = BigDecimal.ZERO;
        //平台优惠券最后一次券的抵扣金额（平台券总额 - 前面所有抵扣金额的和）
        BigDecimal lastPlatformDiscountAmount = BigDecimal.ZERO;
        if (shoppingCartVO.getPlatformCouponId() != null && shoppingCartVO.getPlatformCoupon() == true) {
            SaleInfo temp = saleInfoService.selectByPrimaryKey(shoppingCartVO.getPlatformCouponId());
            //判断券的过期时间
            if (temp != null && temp.getInvalidDate().after(new Date())) {
                platformSaleInfo = temp;
                platformSaleInfoAmount = platformSaleInfo.getAmount();
            }
        }

        //所有商品的总价 （平台优惠券算权重要用到）,不算运费
        //装载店铺信息
        //装载优惠券信息
        //装载商品信息
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (int i = 0; i < shoppingCartVO.getShopList().size(); i++) {
            ShoppingCartVO.ShopDetail shopDetail = shoppingCartVO.getShopList().get(i);

            //装载店铺信息
            ShopInfo shop = shopInfoService.selectByPrimaryKey(shopDetail.getShopId());
            shoppingCartVO.getShopList().get(i).setShop(shop);
            //装载优惠券信息
            SaleInfo saleInfo = saleInfoService.selectByPrimaryKey(shopDetail.getCouponId());
            shoppingCartVO.getShopList().get(i).setCoupon(saleInfo);

            //装载商品信息
            //计算商品总价
            for (int j = 0; j < shopDetail.getProducts().size(); j++) {
                ShoppingCartVO.ProductDetail productDetail = shopDetail.getProducts().get(i);
                ItemInfo item = itemInfoService.selectByPrimaryKey(productDetail.getItemId());
                shopDetail.getProducts().get(i).setItemInfo(ItemInfoMapper.modelToVO(item));
                totalAmount = totalAmount.add(item.getPrice().multiply(new BigDecimal(productDetail.getNum())));
            }
        }

        //实际总金额
        BigDecimal actualAmount = BigDecimal.ZERO;

        for (int i = 0; i < shoppingCartVO.getShopList().size(); i++) {
            ShoppingCartVO.ShopDetail shopDetail = shoppingCartVO.getShopList().get(i);
            shoppingCartVO.getShopList().get(i).setShop(shopInfoService.selectByPrimaryKey(shopDetail.getShopId()));

            //店铺优惠券
            SaleInfo shopSaleInfo = null;
            //商家券优惠金额
            BigDecimal shopSaleInfoAmount = BigDecimal.ZERO;
            //商家券每次减扣的金额的和
            BigDecimal shopDiscountAmount = BigDecimal.ZERO;
            //商家券最后一次券的抵扣金额（券总额 - 前面所有抵扣金额的和）
            BigDecimal lastShopDiscountAmount = BigDecimal.ZERO;
            if (shopDetail.getCouponId() != null && shopDetail.isWithCoupon() == true) {
                SaleInfo temp = saleInfoService.selectByPrimaryKey(shopDetail.getCouponId());
                //判断券的过期时间
                if (temp != null && temp.getInvalidDate().after(new Date())) {
                    shopSaleInfo = temp;
                    shopSaleInfoAmount = shopSaleInfo.getAmount();
                }
            }
            shoppingCartVO.getShopList().get(i).setCoupon(shopSaleInfo);

            //单个店铺商品的总价(不算运费)
            BigDecimal marketTotal = BigDecimal.ZERO;
            //单个店铺的实际支付金额
            BigDecimal actualTotal = BigDecimal.ZERO;

            //装载 itemInfo ,单个店铺商品的总价
            for (int j = 0; j < shopDetail.getProducts().size(); j++) {
                ItemInfo itemInfo = itemInfoService.selectByPrimaryKey(shopDetail.getProducts().get(i).getItemId());
                shopDetail.getProducts().get(i).setItemInfo(ItemInfoMapper.modelToVO(itemInfo));
                marketTotal = marketTotal.add(itemInfo.getPrice().multiply(new BigDecimal(shopDetail.getProducts().get(i).getNum())));
            }

            for (int j = 0; j < shopDetail.getProducts().size(); j++) {
                ShoppingCartVO.ProductDetail product = shopDetail.getProducts().get(i);
                ShoppingCartVO.Price price = new ShoppingCartVO.Price();

                //单个商品的价格
                BigDecimal productMarketPrice = BigDecimal.ZERO;

                //单个商品的实际价格（扣减券后的）
                BigDecimal productActualPrice = BigDecimal.ZERO;

                //单个商品的平台优惠金额
                BigDecimal productPlatformDiscountPrice = BigDecimal.ZERO;

                //单个商品的店铺优惠金额
                BigDecimal productShopDiscountPrice = BigDecimal.ZERO;

                //商家券减扣
                //type 1：全场券（平台） 2：商家券（商家）  3：会员全场券(平台) 4：会员商家券（商家）
                //saleType（1：满减 2：现金券）
                //(如果有券) && 商家券 && ((满减券 && 订单总金额满足满减) || 现金券)
                if (shopDetail.getCouponId() != null && shopSaleInfo != null && shopSaleInfo.getType() == 2 &&
                        ((shopSaleInfo.getSaleType() == 1 && marketTotal.compareTo(shopSaleInfo.getSaleAmount()) > -1) ||
                                shopSaleInfo.getSaleType() == 2)) {

                    //最后一件商品,减扣金额为 券总额 - 前面已减扣的金额的和
                    if (j != shopDetail.getProducts().size() - 1) {
                        //该商品需要减扣的金额(券金额按照商品金额的权重分配减免金额)
                        BigDecimal temp = product.getItemInfo().getPrice().divide(totalAmount, 2, BigDecimal.ROUND_DOWN).multiply(shopSaleInfoAmount);
                        productShopDiscountPrice = temp;
                        shopDiscountAmount = shopDiscountAmount.add(temp.multiply(new BigDecimal(product.getNum())));
                    } else {
                        lastShopDiscountAmount = shopSaleInfoAmount.subtract(shopDiscountAmount);
                        productShopDiscountPrice = lastShopDiscountAmount.divide(new BigDecimal(product.getNum()), 2, BigDecimal.ROUND_DOWN);
                        //shopDiscountAmount = shopDiscountAmount.add(lastShopDiscountAmount.divide(new BigDecimal(product.getNum()), 2, BigDecimal.ROUND_DOWN));
                    }
                }

                //平台券减扣
                //type 1：全场券（平台） 2：商家券（商家）  3：会员全场券(平台) 4：会员商家券（商家）
                //saleType（1：满减 2：现金券）
                //(如果有券) && 平台券 && ((满减券 && 订单总金额满足满减) || 现金券)
                if (shoppingCartVO.getPlatformCouponId() != null && platformSaleInfo != null && platformSaleInfo.getType() == 1 &&
                        ((platformSaleInfo.getSaleType() == 1 && totalAmount.compareTo(platformSaleInfo.getSaleAmount()) > -1) ||
                                platformSaleInfo.getSaleType() == 2)) {
                    if (j != shopDetail.getProducts().size() - 1) {
                        BigDecimal temp = product.getItemInfo().getPrice().divide(totalAmount, 2, BigDecimal.ROUND_DOWN).multiply(platformSaleInfoAmount);
                        productPlatformDiscountPrice = temp;
                        platformDiscountAmount = platformDiscountAmount.add(temp.multiply(new BigDecimal(product.getNum())));
                        productPlatformDiscountPrice = productPlatformDiscountPrice.add(temp.multiply(new BigDecimal(product.getNum())));
                    } else {
                        lastPlatformDiscountAmount = platformSaleInfoAmount.subtract(platformDiscountAmount);
                        productPlatformDiscountPrice = lastPlatformDiscountAmount.divide(new BigDecimal(product.getNum()), 2, BigDecimal.ROUND_DOWN);
                    }
                }

                //计算单个商品的扣减总额（平台+商家）
                BigDecimal tempProductActualPrice = product.getItemInfo().getPrice();
                if(productShopDiscountPrice.compareTo(BigDecimal.ZERO) > -1){
                    tempProductActualPrice = tempProductActualPrice.subtract(productShopDiscountPrice);
                }
                if(productPlatformDiscountPrice.compareTo(BigDecimal.ZERO) > -1){
                    tempProductActualPrice = tempProductActualPrice.subtract(productPlatformDiscountPrice);
                }
                price.setMarket(product.getItemInfo().getPrice());
                price.setActual(tempProductActualPrice.compareTo(BigDecimal.ZERO) > -1 ? tempProductActualPrice : BigDecimal.ZERO);
                shopDetail.getProducts().get(i).setPrice(price);
                actualTotal = actualTotal.add(price.getActual().multiply(new BigDecimal(product.getNum())));
            }

            //装载单个商店商品的总价
            shoppingCartVO.getShopList().get(i).setMarketTotal(marketTotal);
            //装载单个商店商品的实际总价
            shoppingCartVO.getShopList().get(i).setActualTotal(actualTotal);
            //循环加店铺实际总价 得出整个购物车的实际总价
            actualAmount = actualTotal.add(actualTotal);
        }
        // TODO: 6/15/17 总金额,实际支付金额, 需要考虑运费
        shoppingCartVO.setTotalAmount(totalAmount);
        shoppingCartVO.setActualAmount(actualAmount);
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
                // TODO: 6/14/17  运费 ID   计算价格的时候需要考虑
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
                        BigDecimal temp = itemInfo.getPrice().divide(orderTotalAmount, 2, BigDecimal.ROUND_DOWN).multiply(shopSaleInfoAmount);
                        shopDiscountAmount = shopSaleInfoAmount.add(temp.multiply(new BigDecimal(product.getNumber())));
                        orderDetail.setShopPromotionCost(temp);
                    } else {
                        lastShopDiscountAmount = shopSaleInfoAmount.subtract(shopDiscountAmount);
                        orderDetail.setShopPromotionCost(lastShopDiscountAmount.divide(new BigDecimal(product.getNumber()), 2, BigDecimal.ROUND_DOWN));
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
                        BigDecimal temp = itemInfo.getPrice().divide(totalProductAmount, 2, BigDecimal.ROUND_DOWN).multiply(platformSaleInfoAmount);
                        platformDiscountAmount = platformDiscountAmount.add(temp.multiply(new BigDecimal(product.getNumber())));
                        orderDetail.setPlatformPromotionCost(temp);
                    } else {
                        lastPlatformDiscountAmount = platformSaleInfoAmount.subtract(platformDiscountAmount);
                        orderDetail.setPlatformPromotionCost(lastPlatformDiscountAmount.divide(new BigDecimal(product.getNumber()), 2, BigDecimal.ROUND_DOWN));
                    }
                }
                orderDetailService.addOrderDetail(orderDetail);


                BigDecimal productActual = product.getItemInfo().getPrice().multiply(new BigDecimal(product.getNumber()));
                if (orderDetail.getPlatformPromotionCost() != null) {
                    productActual = productActual.subtract(orderDetail.getPlatformPromotionCost().multiply(new BigDecimal(orderDetail.getItemCount())));
                }
                if (orderDetail.getShopPromotionCost() != null) {
                    productActual = productActual.subtract(orderDetail.getShopPromotionCost().multiply(new BigDecimal(orderDetail.getItemCount())));
                }
                orderActualAmount = orderActualAmount.add(productActual.compareTo(BigDecimal.ZERO) > -1 ? productActual : BigDecimal.ZERO);
            }

            // TODO: 6/15/17 总金额,实际支付金额, 需要考虑运费
            orderHeader.setTotalAmount(orderTotalAmount);
            orderHeader.setActualAmount(orderActualAmount);
            this.addOrderHeader(orderHeader);
        }

        return orderInfoVO;
    }


}
