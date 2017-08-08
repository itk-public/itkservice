package com.itk.order.service;

import com.itk.base.model.ShopInfo;
import com.itk.base.service.ShopInfoService;
import com.itk.dto.OrderInfoDTO;
import com.itk.dto.PurchaseInfoDTO;
import com.itk.exception.ResultCode;
import com.itk.exception.SystemException;
import com.itk.item.convert.ItemInfoConvert;
import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoService;
import com.itk.order.convert.OrderInfoConvert;
import com.itk.order.convert.PurchaseInfoConvert;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderInfoVO;
import com.itk.order.model.PurchaseInfoVO;
import com.itk.order.model.ShoppingCartVO;
import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoService;
import com.itk.security.SecurityUtils;
import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoService;
import com.itk.user.service.UserShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    UserInfoService userInfoService;

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
                shopDetail.getProducts().get(i).setItemInfo(ItemInfoConvert.modelToVO(item));
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
                shopDetail.getProducts().get(i).setItemInfo(ItemInfoConvert.modelToVO(itemInfo));
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
                if (productShopDiscountPrice.compareTo(BigDecimal.ZERO) > -1) {
                    tempProductActualPrice = tempProductActualPrice.subtract(productShopDiscountPrice);
                }
                if (productPlatformDiscountPrice.compareTo(BigDecimal.ZERO) > -1) {
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

    public OrderInfoVO getSubmitOrderDetail(OrderInfoVO orderInfoVO) {
        String login = SecurityUtils.getCurrentUserLogin();
        UserInfo userInfo = userInfoService.findUserByPhone(login);
        OrderInfoDTO orderInfoDTO = orderHeaderService.getSubmitOrderDetail(OrderInfoConvert.OrderInfoVOToDTO(orderInfoVO),userInfo.getUserId());
        return OrderInfoConvert.OrderInfoDTOToVO(orderInfoDTO);
    }

    public PurchaseInfoVO purchaseOrders(PurchaseInfoVO purchaseInfoVO) {
        PurchaseInfoDTO purchaseInfoDTO = PurchaseInfoConvert.PurchaseInfoVOToDTO(purchaseInfoVO);
        return PurchaseInfoConvert.PurchaseInfoDTOToVO(orderHeaderService.purchaseOrders(purchaseInfoDTO));
    }

    public OrderHeader orderComplete(String orderId) {
        return orderHeaderService.orderComplete(orderId);
    }

    public OrderHeader orderCancel(String orderId) {
        return orderHeaderService.orderCancel(orderId);
    }

    public OrderHeader orderAllocationFlow(String orderId, Integer status, Integer allocationType, Date allocationFromTime, Date allocationToTime, Integer pickSelfLocationId, Date arrivalTime) {
        return orderHeaderService.orderAllocationFlow(orderId, status, allocationType, allocationFromTime, allocationToTime, pickSelfLocationId, arrivalTime);
    }
}
