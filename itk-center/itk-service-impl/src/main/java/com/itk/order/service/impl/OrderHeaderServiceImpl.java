package com.itk.order.service.impl;

import com.itk.order.mapper.OrderHeaderMapper;
import com.itk.order.model.OrderHeader;
import com.itk.order.service.OrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by enchen on 5/6/17.
 */
public class OrderHeaderServiceImpl implements OrderHeaderService{

    @Autowired
    OrderHeaderMapper orderHeaderMapper;

    @Override
    public int addOrderHeader(OrderHeader orderHeader) {
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
        return orderHeaderMapper.updateByPrimaryKeySelective(orderHeader);
    }

    @Override
    public OrderHeader selectByOrderId(String orderId) {
        return orderHeaderMapper.selectByOrderId(orderId);
    }
}
