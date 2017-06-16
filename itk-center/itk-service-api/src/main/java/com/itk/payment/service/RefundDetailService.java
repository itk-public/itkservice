package com.itk.payment.service;


import com.itk.payment.model.RefundDetail;

/**
 * Created by enchen on 5/5/17.
 */
public interface RefundDetailService {

    int insertSelective(RefundDetail refundDetail);

    int updateByPrimaryKeySelective(RefundDetail refundDetail);

    RefundDetail selectByRefundDetailId(String refundDetailId);

    RefundDetail selectByRefundFlowId(String refundFlowId);
}
