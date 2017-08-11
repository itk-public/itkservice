package com.itk.payment.service.impl;

import com.itk.enumeration.OperatorTypeEnum;
import com.itk.enumeration.RefundOperateIdEnum;
import com.itk.payment.mapper.RefundHistoryMapper;
import com.itk.payment.model.RefundHistory;
import com.itk.payment.model.RefundHistoryExample;
import com.itk.payment.service.RefundHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 8/10/17.
 */
public class RefundHistoryServiceImpl implements RefundHistoryService {

    @Autowired
    RefundHistoryMapper refundHistoryMapper;

    private RefundHistory addRefundHistory(RefundHistory refundHistory, String operatorId) {
        refundHistory.setCreateBy(operatorId);
        refundHistory.setUpdateBy(operatorId);
        refundHistory.setCreateTime(new Date());
        refundHistory.setUpdateTime(new Date());
        refundHistoryMapper.insert(refundHistory);
        return refundHistory;
    }

    private RefundHistory addDoneRefundHistory(RefundHistory refundHistory) {
        refundHistory.setCreateTime(new Date());
        refundHistory.setUpdateTime(new Date());
        refundHistoryMapper.insert(refundHistory);
        return refundHistory;
    }

    /**
     * 添加提交申请记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    @Override
    public RefundHistory addRefundSubmitHistory(String refundFlowId, String operateDetail, String operatorId) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.CUSTOMER.getID());
        refundHistory.setOperateId(RefundOperateIdEnum.SUBMIT.getID());
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加撤销申请记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    @Override
    public RefundHistory addRefundWithdrawHistory(String refundFlowId, String operateDetail, String operatorId) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.CUSTOMER.getID());
        refundHistory.setOperateId(RefundOperateIdEnum.WITHDRAW.getID());
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加商家初步处理记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @param isPass        true 通过     false 驳回
     * @return
     */
    @Override
    public RefundHistory addBusinessApprovalHistory(String refundFlowId, String operateDetail, String operatorId, boolean isPass) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.BUSINESS_ADMIN.getID());
        if (isPass) {
            refundHistory.setOperateId(RefundOperateIdEnum.BUSINESS_PASS.getID());
        } else {
            refundHistory.setOperateId(RefundOperateIdEnum.BUSINESS_REJECT.getID());
        }
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加用户确认发货记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    @Override
    public RefundHistory addCustomerShipConfirmHistory(String refundFlowId, String operateDetail, String operatorId) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.CUSTOMER.getID());
        refundHistory.setOperateId(RefundOperateIdEnum.SHIP_CONFIRM.getID());
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加商家确认收货记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @param isPass        true 确认收货     false 商家收货后驳回
     * @return
     */
    @Override
    public RefundHistory addBusinessReceivedApprovalHistory(String refundFlowId, String operateDetail, String operatorId, boolean isPass) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.BUSINESS_ADMIN.getID());
        if (isPass) {
            refundHistory.setOperateId(RefundOperateIdEnum.RECEIVE_CONFIRM.getID());
        } else {
            refundHistory.setOperateId(RefundOperateIdEnum.BUSINESS_REJECT_WITH_COMMODITY.getID());
        }
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加发起退款记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @param operatorId
     * @return
     */
    @Override
    public RefundHistory addStartPayRefundHistory(String refundFlowId, String operateDetail, String operatorId) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(OperatorTypeEnum.CUSTOMER.getID());
        refundHistory.setOperateId(RefundOperateIdEnum.START_PAY_BACK.getID());
        return addRefundHistory(refundHistory, operatorId);
    }

    /**
     * 添加退款完成记录
     *
     * @param refundFlowId
     * @param operateDetail
     * @return
     */
    @Override
    public RefundHistory addDonePayRefundHistory(String refundFlowId, String operateDetail, OperatorTypeEnum operatorTypeEnum) {
        RefundHistory refundHistory = new RefundHistory();
        refundHistory.setRefundFlowId(refundFlowId);
        refundHistory.setOperateDetail(operateDetail);
        refundHistory.setOperatorTypeId(operatorTypeEnum.getID());
        refundHistory.setOperateId(RefundOperateIdEnum.DONE_PAY_BACK.getID());
        return addDoneRefundHistory(refundHistory);
    }

    /**
     * 获取退款历史列表
     *
     * @param refundFlowId
     * @return
     */
    @Override
    public List<RefundHistory> getRefundApprovalHistory(String refundFlowId) {
        RefundHistoryExample refundHistoryExample = new RefundHistoryExample();
        refundHistoryExample
                .or()
                .andRefundFlowIdEqualTo(refundFlowId);
        refundHistoryExample.setOrderByClause("create_time desc");
        return refundHistoryMapper.selectByExample(refundHistoryExample);
    }
}
