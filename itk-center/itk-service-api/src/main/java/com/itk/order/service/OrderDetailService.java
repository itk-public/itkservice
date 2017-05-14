package com.itk.order.service;

import com.itk.order.model.OrderDetail;

/**
 * Created by enchen on 5/6/17.
 */
public interface OrderDetailService {

    int addOrderDetail(OrderDetail orderDetail);

    int updateOrderDetail(OrderDetail orderDetail);

    OrderDetail selectByOrderId(String orderId);
}
