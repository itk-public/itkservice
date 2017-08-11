package com.itk.payment.service;

import com.itk.enumeration.OperatorTypeEnum;
import com.itk.payment.model.RefundHistory;

import java.util.List;

/**
 * Created by enchen on 8/10/17.
 */
public interface RefundHistoryService {

    /**
     * 添加提交申请记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    RefundHistory addRefundSubmitHistory(String refundFlowId, String operateDetail, String operatorId);

    /**
     * 添加撤销申请记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    RefundHistory addRefundWithdrawHistory(String refundFlowId, String operateDetail, String operatorId);

    /**
     * 添加商家初步处理记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @param isPass    true 通过     false 驳回
     * @return
     */
    RefundHistory addBusinessApprovalHistory(String refundFlowId, String operateDetail, String operatorId, boolean isPass);

    /**
     * 添加用户确认发货记录
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    RefundHistory addCustomerShipConfirmHistory(String refundFlowId, String operateDetail, String operatorId);

    /**
     * 添加商户收货处理记录
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @param isPass    true 确认收货     false 商家收货后驳回
     * @return
     */
    RefundHistory addBusinessReceivedApprovalHistory(String refundFlowId, String operateDetail, String operatorId, boolean isPass);

    /**
     * 添加发起退款记录
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    RefundHistory addStartPayRefundHistory(String refundFlowId, String operateDetail, String operatorId);

    /**
     * 添加退款完成记录
     * @param refundFlowId
     * @param operateDetail
     * @return
     */
    RefundHistory addDonePayRefundHistory(String refundFlowId, String operateDetail, OperatorTypeEnum operatorTypeEnum);

    /**
     * 获取某个单据的操作历史
     *
     * @param refundFlowId
     * @return
     */
    List<RefundHistory> getRefundApprovalHistory(String refundFlowId);
}
