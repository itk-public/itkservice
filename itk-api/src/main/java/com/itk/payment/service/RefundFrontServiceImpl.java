package com.itk.payment.service;

import com.itk.exception.SystemException;
import com.itk.payment.convert.RefundInfoConvert;
import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundInfoVO;
import com.itk.security.SecurityUtils;
import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoService;
import com.itk.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class RefundFrontServiceImpl {

    @Autowired
    RefundProcessService refundProcessService;

    @Autowired
    UserInfoService userInfoService;

    public RefundInfoDTO submitRefund(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO.getOrderId()) {
            throw new SystemException(ResultCode.REFUND_ORDER_UNKNOWN, "Refund Order Required");
        }
        if (null == refundInfoVO.getReason()) {
            throw new SystemException(ResultCode.REFUND_REASON_REQUIRED, "Refund Reason Required");
        }
        RefundInfoDTO refundInfoDTO = this.refundInfoVOTODTOConvert(refundInfoVO);
        String login = SecurityUtils.getCurrentUserLogin();
        UserInfo userInfo = userInfoService.findUserByPhone(login);
        String userId = userInfo.getUserId();
        return refundProcessService.submitRefund(refundInfoDTO, userId);
    }

    public RefundInfoDTO withdrawRefund(String flowId) {
        String login = SecurityUtils.getCurrentUserLogin();
        UserInfo userInfo = userInfoService.findUserByPhone(login);
        refundProcessService.withdrawRefund(flowId, userInfo.getUserId());
        return this.selectRefundInfoByFlowId(flowId);
    }

    public RefundInfoDTO businessPassRefund(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO.getAddress()) {
            throw new SystemException(ResultCode.REFUND_ADDRESS_REQUIRED, "Refund Address Required");
        }
        refundProcessService.businessPassRefund(refundInfoVO.getFlowId(), refundInfoVO.getAddress());
        return this.selectRefundInfoByFlowId(refundInfoVO.getFlowId());
    }

    public RefundInfoDTO businessRejectRefund(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO.getRejectReason()) {
            throw new SystemException(ResultCode.REFUND_REJECT_REASON, "Reject Reason Required");
        }
        refundProcessService.businessRejectRefund(refundInfoVO.getFlowId(), refundInfoVO.getRejectReason());
        return this.selectRefundInfoByFlowId(refundInfoVO.getFlowId());
    }

    public RefundInfoDTO customerShipConfirm(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO.getExpressCompany()) {
            throw new SystemException(ResultCode.REFUND_EXPRESS_COMPANY_REQUIRED, "Express Company Required");
        }
        if (null == refundInfoVO.getExpressNo()) {
            throw new SystemException(ResultCode.REFUND_EXPRESS_NO_REQUIRED, "Express No Required");
        }
        RefundInfoDTO refundInfoDTO = this.refundInfoVOTODTOConvert(refundInfoVO);
        String login = SecurityUtils.getCurrentUserLogin();
        UserInfo userInfo = userInfoService.findUserByPhone(login);
        String userId = userInfo.getUserId();
        refundProcessService.customerShipConfirm(refundInfoDTO, userId);
        return this.selectRefundInfoByFlowId(refundInfoVO.getFlowId());
    }

    public RefundInfoDTO businessReceivedConfirm(String flowId) {
        refundProcessService.businessReceivedConfirm(flowId);
        return this.selectRefundInfoByFlowId(flowId);
    }

    public RefundInfoDTO businessRejectWithCommodity(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO.getRejectReasonReceived()) {
            throw new SystemException(ResultCode.REFUND_REJECT_RECEIVED_REASON, "Reject With Commodity Reason Required");
        }
        refundProcessService.businessRejectWithCommodity(refundInfoVO.getFlowId(), refundInfoVO.getRejectReasonReceived());
        return this.selectRefundInfoByFlowId(refundInfoVO.getFlowId());
    }

    public RefundInfoDTO businessStartPayBack(String flowId) {
        refundProcessService.businessStartPayBack(flowId);
        return this.selectRefundInfoByFlowId(flowId);
    }

    public RefundInfoDTO completeRefundPayBack(String flowId, Integer operator) {
        refundProcessService.completeRefundPayBack(flowId, operator);
        return this.selectRefundInfoByFlowId(flowId);
    }

    public RefundInfoDTO selectRefundInfoByFlowId(String flowId) {
        return refundProcessService.selectRefundByFlowId(flowId);
    }

    private RefundInfoDTO refundInfoVOTODTOConvert(RefundInfoVO refundInfoVO) {
        refundInfoVO.getRefundDetails()
                .stream()
                .map(refundDetailVO -> {
                    if (null == refundDetailVO.getOrderDetailId()) {
                        throw new SystemException(ResultCode.REFUND_ORDER_DETAIL_UNKNOWN, "Refund Order Detail Required");
                    }
                    return refundDetailVO;
                })
                .collect(Collectors.toList());
        return RefundInfoConvert.RefundInfoVOToDTO(refundInfoVO);
    }
}
