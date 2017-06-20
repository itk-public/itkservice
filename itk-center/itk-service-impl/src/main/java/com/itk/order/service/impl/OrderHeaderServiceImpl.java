package com.itk.order.service.impl;

import com.itk.base.service.ShopInfoService;
import com.itk.dto.model.OrderInfoDTO;
import com.itk.dto.model.ShoppingCartDTO;
import com.itk.item.mapper.ItemInfoMapper;
import com.itk.item.service.ItemInfoService;
import com.itk.order.mapper.OrderHeaderMapper;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderHeaderExample;
import com.itk.order.service.OrderDetailService;
import com.itk.order.service.OrderHeaderService;
import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoService;
import com.itk.user.service.UserShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enchen on 5/6/17.
 */
public class OrderHeaderServiceImpl implements OrderHeaderService{

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
    public OrderInfoDTO getOrderInfoDetail(ShoppingCartDTO shoppingCartDTO) {

        return null;
    }

    @Override
    public OrderInfoDTO getPurchaseOrderDetail(OrderInfoDTO orderInfoDTO) {
        return null;
    }
}
