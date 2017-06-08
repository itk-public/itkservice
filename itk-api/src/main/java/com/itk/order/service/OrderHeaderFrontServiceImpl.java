package com.itk.order.service;

import com.itk.base.service.ShopInfoService;
import com.itk.item.service.ItemInfoService;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.ShoppingCartVO;
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
public class OrderHeaderFrontServiceImpl {

    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    UserShippingAddressService userShippingAddressService;

    @Autowired
    ShopInfoService shopInfoService;

    @Autowired
    ItemInfoService itemInfoService;

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

    public ShoppingCartVO getOrderInfoVoDetail(ShoppingCartVO orderInfoVO) {
        ShoppingCartVO.ReceiveInfo receiveInfo = new ShoppingCartVO.ReceiveInfo();
        receiveInfo.setUserShippingAddress(userShippingAddressService.selectByPrimaryKey(orderInfoVO.getAddressId()));
        receiveInfo.setShopInfo(shopInfoService.selectByPrimaryKey(orderInfoVO.getShopId()));
        List<ShoppingCartVO.ShopDetail> shopDetailList = orderInfoVO.getShopList();
        shopDetailList.stream().map(shopDetail -> {
            shopDetail.setShop(shopInfoService.selectByPrimaryKey(orderInfoVO.getShopId()));
            // TODO: 6/7/17 优惠券扣减
            shopDetail.getProducts().stream().map(productDetail -> {
                productDetail.setItemInfo(itemInfoService.selectByPrimaryKey(productDetail.getItemId()));
                ShoppingCartVO.Price price = new ShoppingCartVO.Price();
                price.setMarket(productDetail.getItemInfo().getPrice().subtract(new BigDecimal(productDetail.getNumber())));
                price.setTotal(productDetail.getItemInfo().getPrice().subtract(new BigDecimal(productDetail.getNumber())));
                price.setValue(productDetail.getItemInfo().getPrice().subtract(new BigDecimal(productDetail.getNumber())));
                productDetail.setPrice(price);
                return productDetail;
            }).collect(Collectors.toList());

            BigDecimal totalPayment = shopDetail.getProducts().stream().map(productDetail -> {
                return productDetail.getPrice().getMarket();
            }).reduce(BigDecimal.ZERO, BigDecimal::add);

            shopDetail.setTotalPayment(totalPayment);
            return shopDetail;
        }).collect(Collectors.toList());

        orderInfoVO.setShopList(shopDetailList);
        return orderInfoVO;
    }
}
