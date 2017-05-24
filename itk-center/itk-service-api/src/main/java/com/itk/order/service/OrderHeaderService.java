package com.itk.order.service;

import com.itk.order.model.OrderHeader;

/**
 * Created by enchen on 5/6/17.
 */
public interface OrderHeaderService {

    int addOrderHeader(OrderHeader orderHeader);

    int delOrderHeader(Long id);

    int updateOrderHeader(OrderHeader orderHeader);

    OrderHeader selectByOrderId(String orderId);
}