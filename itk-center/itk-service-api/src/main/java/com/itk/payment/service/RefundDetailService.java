package com.itk.payment.service;


import com.itk.payment.model.RefundDetail;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public interface RefundDetailService {

    RefundDetail insertSelective(RefundDetail refundDetail);

    RefundDetail updateByPrimaryKeySelective(RefundDetail refundDetail);

    RefundDetail selectByRefundDetailId(String refundDetailId);

    List<RefundDetail> selectByRefundFlowId(String refundFlowId);
}
