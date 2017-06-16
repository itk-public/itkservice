package com.itk.payment.service;


import com.itk.payment.model.RefundFlow;

/**
 * Created by enchen on 5/5/17.
 */
public interface RefundFlowService {

    int insertSelective(RefundFlow refundFlow);

    int updateByPrimaryKeySelective(RefundFlow refundFlow);

    RefundFlow selectByRefundFlowId(String refundFlowId);

    RefundFlow selectByPurchaseId(String purchaseId);
}
