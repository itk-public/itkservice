package com.itk.payment.service;


import com.itk.payment.model.RefundFlow;

/**
 * Created by enchen on 5/5/17.
 */
public interface RefundFlowService {

    RefundFlow insertSelective(RefundFlow refundFlow);

    RefundFlow updateByPrimaryKeySelective(RefundFlow refundFlow);

    RefundFlow selectByRefundFlowId(String refundFlowId);

    RefundFlow selectByPurchaseId(String purchaseId);
}
