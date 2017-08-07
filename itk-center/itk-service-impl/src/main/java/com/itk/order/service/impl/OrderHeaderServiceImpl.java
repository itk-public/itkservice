package com.itk.order.service.impl;

import com.itk.base.service.ShopInfoService;
import com.itk.dto.OrderInfoDTO;
import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoService;
import com.itk.order.convert.OrderHeaderMapper;
import com.itk.order.model.OrderDetail;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderHeaderExample;
import com.itk.order.service.OrderDetailService;
import com.itk.order.service.OrderHeaderService;
import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoService;
import com.itk.user.service.UserShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 5/6/17.
 */
public class OrderHeaderServiceImpl implements OrderHeaderService {

    @Autowired
    OrderHeaderMapper orderHeaderMapper;

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

    @Override
    public int addOrderHeader(OrderHeader orderHeader) {
        orderHeader.setCreateTime(new Date());
        orderHeader.setStatus(0);
        orderHeader.setIsDel(0);
        orderHeader.setIsExpired(0);
        return orderHeaderMapper.insertSelective(orderHeader);
    }

    @Override
    public int delOrderHeader(Long id) {
        OrderHeader orderHeader = orderHeaderMapper.selectByPrimaryKey(id);
        orderHeader.setIsDel(1);
        return orderHeaderMapper.updateByPrimaryKeySelective(orderHeader);
    }

    @Override
    public int updateOrderHeader(OrderHeader orderHeader) {
        orderHeader.setModifyTime(new Date());
        return orderHeaderMapper.updateByPrimaryKeySelective(orderHeader);
    }

    @Override
    public OrderHeader selectByOrderId(String orderId) {
        OrderHeaderExample orderHeaderExample = new OrderHeaderExample();
        orderHeaderExample.or().andOrderIdEqualTo(orderId);
        List<OrderHeader> orderHeaderList = orderHeaderMapper.selectByExample(orderHeaderExample);
        return orderHeaderList.size() > 0 ? orderHeaderList.get(0) : null;
    }

    @Override
    @Transactional
    public OrderInfoDTO getPurchaseOrderDetail(OrderInfoDTO orderInfoDTO, String orderID) {
        //平台优惠券
        SaleInfo platformSaleInfo = null;
        //平台优惠券金额
        BigDecimal platformSaleInfoAmount = BigDecimal.ZERO;
        //平台优惠券每次减扣的金额的和
        BigDecimal platformDiscountAmount = BigDecimal.ZERO;
        //平台优惠券最后一次券的抵扣金额（平台券总额 - 前面所有抵扣金额的和）
        BigDecimal lastPlatformDiscountAmount = BigDecimal.ZERO;
        if (orderInfoDTO.getPlatformCouponId() != null) {
            SaleInfo temp = saleInfoService.selectByPrimaryKey(orderInfoDTO.getPlatformCouponId());
            //判断券的过期时间
            if (temp != null && temp.getInvalidDate().after(new Date())) {
                platformSaleInfo = temp;
                platformSaleInfoAmount = platformSaleInfo.getAmount();
            }
        }

        // TODO: 6/20/17 需要考虑运费
        //实际支付总价
        BigDecimal actualTotalAmount = BigDecimal.ZERO;

        //所有商品的总价 （平台优惠券算权重要用到）,不算运费
        BigDecimal totalProductAmount = BigDecimal.ZERO;
        //计算所有商品的总价
        for (int i = 0; i < orderInfoDTO.getOrderList().size(); i++) {
            List<OrderInfoDTO.Product> products = orderInfoDTO.getOrderList().get(i).getProducts();
            for (int j = 0; j < products.size(); j++) {
                ItemInfo tempItemInfo = itemInfoService.selectByPrimaryKey(products.get(j).getItemId());
                totalProductAmount = totalProductAmount.add(tempItemInfo.getPrice().multiply(new BigDecimal(products.get(j).getNumber())));
            }
        }

        List<OrderInfoDTO.OrderShopDetail> orderList = orderInfoDTO.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            OrderInfoDTO.OrderShopDetail order = orderList.get(i);
            OrderHeader orderHeader = new OrderHeader();
            orderHeader.setOrderId(orderID);
            orderHeader.setStatus(1);
            orderHeader.setAddressId(orderInfoDTO.getAddressId());
            orderHeader.setShopId(order.getShopId());
            orderHeader.setAllocationType(orderInfoDTO.getAllocationType());

            //配送方式(0: 平台配送, 1: 用户自提)
            if (0 == orderHeader.getAllocationType()) {
                //orderHeader.setAllocationFromTime();
                //orderHeader.setAllocationToTime();
                //orderHeader.setArrivalTime();
                //orderHeader.setCompleteTime();
            } else {
                if (orderInfoDTO.getPickSelfLocationId() == null) {
                    //todo throw exception
                    //throw new SystemException(2001);
                }
                orderHeader.setPickSelfLocationId(orderInfoDTO.getPickSelfLocationId());
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
                OrderInfoDTO.Product product = order.getProducts().get(j);
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
                if (orderInfoDTO.getPlatformCouponId() != null && platformSaleInfo != null && platformSaleInfo.getType() == 1 &&
                        ((platformSaleInfo.getSaleType() == 1 && totalProductAmount.compareTo(platformSaleInfo.getSaleAmount()) > -1) ||
                                platformSaleInfo.getSaleType() == 2)) {
                    orderDetail.setPlatformPromotionCode(orderInfoDTO.getPlatformCouponId());
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

                //单个商品减免折扣后实际的价格
                BigDecimal productActualPrice = product.getItemInfo().getPrice();
                //单个商品实际价格（与数量相乘）
                BigDecimal productActual = product.getItemInfo().getPrice().multiply(new BigDecimal(product.getNumber()));
                if (orderDetail.getPlatformPromotionCost() != null) {
                    productActualPrice = productActualPrice.subtract(orderDetail.getPlatformPromotionCost());
                    productActual = productActual.subtract(orderDetail.getPlatformPromotionCost().multiply(new BigDecimal(orderDetail.getItemCount())));
                }
                if (orderDetail.getShopPromotionCost() != null) {
                    productActualPrice = productActualPrice.subtract(orderDetail.getShopPromotionCost());
                    productActual = productActual.subtract(orderDetail.getShopPromotionCost().multiply(new BigDecimal(orderDetail.getItemCount())));
                }
                //装载单个商品减免折扣后的价格
                orderList.get(i).getProducts().get(j).setActualPrice(productActualPrice);
                orderActualAmount = orderActualAmount.add(productActual.compareTo(BigDecimal.ZERO) > -1 ? productActual : BigDecimal.ZERO);
            }
            orderList.get(i).setActualAmount(orderActualAmount);
            // TODO: 6/15/17 总金额,实际支付金额, 需要考虑运费
            orderHeader.setTotalAmount(orderTotalAmount);
            orderHeader.setActualAmount(orderActualAmount);
            this.addOrderHeader(orderHeader);
            //循环相加单个订单的实际金额
            actualTotalAmount = actualTotalAmount.add(orderActualAmount);
        }
        //装载所有订单总共需要支付的价格
        orderInfoDTO.setActualTotalAmount(actualTotalAmount);
        return orderInfoDTO;
    }

    @Override
    @Transactional
    public OrderHeader orderComplete(String orderId) {
        OrderHeader orderHeader = this.selectByOrderId(orderId);
        if (null != orderHeader) {
            orderHeader.setStatus(6);// status 6    已完成
            orderHeader.setCompleteTime(new Date());
            this.updateOrderHeader(orderHeader);
            return orderHeader;
        }
        return orderHeader;
    }

    @Override
    public OrderHeader orderCancel(String orderId) {
        OrderHeader orderHeader = this.selectByOrderId(orderId);
        if (null != orderHeader) {
            orderHeader.setStatus(7);// status 7    取消
            this.updateOrderHeader(orderHeader);
            return orderHeader;
        }
        return orderHeader;
    }

    @Override
    @Transactional
    public OrderHeader orderAllocationFlow(String orderId, Integer status, Integer allocationType, Date allocationFromTime, Date allocationToTime, Integer pickSelfLocationId, Date arrivalTime) {
        OrderHeader orderHeader = this.selectByOrderId(orderId);
        orderHeader.setStatus(status);
        orderHeader.setAllocationType(allocationType);
        switch (status) {
            case 3:
                if (allocationType == 0 && allocationFromTime != null && allocationToTime != null) {
                    orderHeader.setAllocationFromTime(allocationFromTime);
                    orderHeader.setAllocationToTime(allocationToTime);
                } else {
                    // TODO: 6/22/17 throw exception
                }
                break;
            case 4:
                if (allocationType == 1 && pickSelfLocationId != null) {
                    orderHeader.setPickSelfLocationId(pickSelfLocationId);
                } else {
                    // TODO: 6/22/17 throw exception
                }
                break;
            case 5:
                if (arrivalTime != null) {
                    orderHeader.setArrivalTime(arrivalTime);
                }
                break;
            default:
                break;
        }
        this.updateOrderHeader(orderHeader);
        return orderHeader;
    }

}
