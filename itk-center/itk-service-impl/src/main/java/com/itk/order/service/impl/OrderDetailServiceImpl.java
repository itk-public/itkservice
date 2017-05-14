package com.itk.order.service.impl;

import com.itk.order.mapper.OrderDetailMapper;
import com.itk.order.model.OrderDetail;
import com.itk.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by enchen on 5/6/17.
 */
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.insertSelective(orderDetail);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public OrderDetail selectByOrderId(String orderId) {
        return orderDetailMapper.selectByOrderId(orderId);
    }
}
