package com.itk.payment.service;

import com.itk.payment.dto.RefundInfoDTO;

/**
 * Created by enchen on 8/10/17.
 */
public interface RefundProcessService {
    RefundInfoDTO submitRefund(RefundInfoDTO refundInfoDTO, String userId);

    void withdrawRefund(String flowId, String userId);

    void businessPassRefund(String flowId, String address);

    void businessRejectRefund(String flowId, String rejectReason);

    void customerShipConfirm(RefundInfoDTO refundInfoDTO, String userId);

    void businessReceivedConfirm(String flowId);

    void businessRejectWithCommodity(String flowId, String rejectReceivedReason);

    void businessStartPayBack(String flowId);

    void completeRefundPayBack(String flowId, Integer operator);

    RefundInfoDTO selectRefundByFlowId(String flowId);
}
