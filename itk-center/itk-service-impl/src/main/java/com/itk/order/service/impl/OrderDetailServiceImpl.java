package com.itk.order.service.impl;

import com.itk.order.convert.OrderDetailMapper;
import com.itk.order.model.OrderDetail;
import com.itk.order.model.OrderDetailExample;
import com.itk.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List<OrderDetail> selectByOrderId(String orderId) {
        OrderDetailExample example = new OrderDetailExample();
        example
                .or()
                .andOrderIdEqualTo(orderId);
        return orderDetailMapper.selectByExample(example);
    }
}
