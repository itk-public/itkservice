package com.itk.payment.service.impl;

import com.itk.enumeration.OperatorTypeEnum;
import com.itk.enumeration.RefundOperateIdEnum;
import com.itk.enumeration.RefundStatusEnum;
import com.itk.exception.SystemException;
import com.itk.order.model.OrderDetail;
import com.itk.order.model.OrderHeader;
import com.itk.order.service.OrderDetailService;
import com.itk.order.service.OrderHeaderService;
import com.itk.payment.convert.RefundDetailBeanConvert;
import com.itk.payment.convert.RefundFlowBeanConvert;
import com.itk.payment.dto.RefundDetailDTO;
import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundDetail;
import com.itk.payment.model.RefundFlow;
import com.itk.payment.service.*;
import com.itk.util.OrderIdUtil;
import com.itk.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by enchen on 8/10/17.
 */
public class RefundProcessServiceImpl implements RefundProcessService {

    @Autowired
    RefundHistoryService refundHistoryService;

    @Autowired
    RefundFlowService refundFlowService;

    @Autowired
    RefundDetailService refundDetailService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    PurchaseService purchaseService;

    @Transactional
    @Override
    public RefundInfoDTO submitRefund(RefundInfoDTO refundInfoDTO, String userId) {
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.SUBMIT);
        //验证操作人
        if (null != refundInfoDTO.getCreateBy() && userId.equals(refundInfoDTO.getCreateBy())) {
            throw new SystemException(ResultCode.OPERATOR_INVALID, "Operator Invalid");
        }
        //加载 orderHeader
        OrderHeader orderHeader = orderHeaderService.selectByOrderId(refundInfoDTO.getOrderId());
        if (null == orderHeader) {
            throw new SystemException(ResultCode.REFUND_ORDER_UNKNOWN, "Refund Order Required");
        }
        //插入 submit refund
        String flowId = OrderIdUtil.refundFlowIDGenerator();
        RefundFlow refundFlow = RefundFlowBeanConvert.RefundInfoDTOToPO(refundInfoDTO);
        if (null == refundInfoDTO.getFlowId()) {
            refundFlow.setCreateBy(userId);
            refundFlow.setFlowId(flowId);
        } else {
            refundFlow.setFlowId(refundInfoDTO.getFlowId());
        }
        refundFlow.setShopId(orderHeader.getShopId());
        refundFlow.setType(0);//退款类型(0: 部分退款, 1: 整单退款)
        refundFlow.setPromotionStatus(0);//退券状态(0: 未退, 1: 已退)
        refundFlow.setStatus(RefundStatusEnum.SUBMIT.getID());
        refundFlow.setCreateTime(new Date());
        refundFlowService.insertSelective(refundFlow);
        List<RefundDetailDTO> refundDetailDTOs = refundInfoDTO.getRefundDetails()
                .stream()
                .map(refundDetailDTO -> {
                    refundDetailDTO.setFlowId(flowId);
                    return upsertRefundDetail(refundDetailDTO);
                })
                .collect(Collectors.toList());

        RefundFlow refundFlowBack = refundFlowService.selectByRefundFlowId(flowId);
        RefundInfoDTO refundInfoDTOBack = RefundFlowBeanConvert.RefundFlowToDTO(refundFlowBack);
        refundInfoDTOBack.setRefundDetails(refundDetailDTOs);
        //添加退款历史
        refundHistoryService.addRefundSubmitHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy());
        return refundInfoDTOBack;
    }

    @Override
    public void withdrawRefund(String flowId, String userId) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.WITHDRAW);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        //验证操作人
        if (userId.equals(refundFlow.getCreateBy())) {
            throw new SystemException(ResultCode.OPERATOR_INVALID, "Operator Invalid");
        }
        refundFlow.setStatus(RefundStatusEnum.WITHDRAW.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addRefundWithdrawHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy());
    }

    @Override
    public void businessPassRefund(String flowId, String address) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.BUSINESS_PASS);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setAddress(address);
        refundFlow.setStatus(RefundStatusEnum.WAIT_SHIP.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addBusinessApprovalHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy(), true);
    }

    @Override
    public void businessRejectRefund(String flowId, String rejectReason) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.BUSINESS_REJECT);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setRejectReason(rejectReason);
        refundFlow.setStatus(RefundStatusEnum.BUSINESS_REJECT.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addBusinessApprovalHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy(), false);
    }

    @Override
    public void customerShipConfirm(RefundInfoDTO refundInfoDTO, String userId) {
        RefundInfoDTO nowRefundInfoDTO = this.selectRefundByFlowId(refundInfoDTO.getFlowId());
        //验证订单状态
        checkRefundOrderStatus(nowRefundInfoDTO, RefundOperateIdEnum.SHIP_CONFIRM);
        //验证操作人
        if (null != refundInfoDTO.getCreateBy() && !userId.equals(refundInfoDTO.getCreateBy())) {
            throw new SystemException(ResultCode.OPERATOR_INVALID, "Operator Invalid");
        }
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(refundInfoDTO.getFlowId());
        refundFlow.setExpressCompany(refundInfoDTO.getExpressCompany());
        refundFlow.setExpressNo(refundInfoDTO.getExpressNo());
        refundFlow.setStatus(RefundStatusEnum.WAIT_RECEIVE_CONFIRM.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addCustomerShipConfirmHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy());
    }

    @Override
    public void businessReceivedConfirm(String flowId) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.RECEIVE_CONFIRM);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setStatus(RefundStatusEnum.RECEIVED_COMMODITY_WAIT_DEAL.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addBusinessReceivedApprovalHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy(), true);
    }

    @Override
    public void businessRejectWithCommodity(String flowId, String rejectReceivedReason) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.BUSINESS_REJECT_WITH_COMMODITY);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setRejectReasonReceived(rejectReceivedReason);
        refundFlow.setStatus(RefundStatusEnum.BUSINESS_REJECT_WITH_COMMODITY.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addBusinessApprovalHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy(), false);
    }

    @Override
    public void businessStartPayBack(String flowId) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.START_PAY_BACK);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setStatus(RefundStatusEnum.WAIT_PAY_BACK.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addStartPayRefundHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy());
        //todo 调用退款的支付逻辑
    }

    @Override
    public void completeRefundPayBack(String flowId, Integer operator) {
        RefundInfoDTO refundInfoDTO = this.selectRefundByFlowId(flowId);
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.DONE_PAY_BACK);
        //更新 退款单状态
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        refundFlow.setStatus(RefundStatusEnum.DONE.getID());
        refundFlowService.updateByPrimaryKeySelective(refundFlow);
        //添加退款历史
        refundHistoryService.addDonePayRefundHistory(refundInfoDTO.getFlowId(), null, OperatorTypeEnum.parse(operator));
    }


    @Override
    public RefundInfoDTO selectRefundByFlowId(String flowId) {
        if (null == flowId) {
            throw new SystemException(ResultCode.REFUND_FLOW_ID_REQUIRED, "Refund flowId Required");
        }
        RefundFlow refundFlow = refundFlowService.selectByRefundFlowId(flowId);
        List<RefundDetail> refundDetails = refundDetailService.selectByRefundFlowId(flowId);
        RefundInfoDTO refundInfoDTO = RefundFlowBeanConvert.RefundFlowToDTO(refundFlow);
        List<RefundDetailDTO> refundDetailDTOs = refundDetails
                .stream()
                .map(RefundDetailBeanConvert::RefundDetailToDTO)
                .collect(Collectors.toList());
        refundInfoDTO.setRefundDetails(refundDetailDTOs);
        return refundInfoDTO;
    }

    private RefundDetailDTO upsertRefundDetail(RefundDetailDTO refundDetailDTO) {
        OrderDetail orderDetail = orderDetailService.selectByPrimaryKey(refundDetailDTO.getOrderDetailId());
        if (null == orderDetail) {
            throw new SystemException(ResultCode.REFUND_ORDER_DETAIL_UNKNOWN, "Refund Order Detail Required");
        }
        RefundDetail refundDetail = new RefundDetail();
        refundDetail.setRefundDetailId(UUID.randomUUID().toString());
        refundDetail.setFlowId(refundDetailDTO.getFlowId());
        refundDetail.setOrderDetailId(refundDetailDTO.getOrderDetailId());
        refundDetail.setPlatformPromotionCode(orderDetail.getPlatformPromotionCode());
        refundDetail.setShopPromotionCode(orderDetail.getShopPromotionCode());
        refundDetail.setRefundCount(refundDetailDTO.getRefundCount());
        if (null == refundDetailDTO.getOrderDetailId()) {
            return RefundDetailBeanConvert.RefundDetailToDTO(refundDetailService.insertSelective(refundDetail));
        } else {
            return RefundDetailBeanConvert.RefundDetailToDTO(refundDetailService.updateByPrimaryKeySelective(refundDetail));
        }

    }

    /**
     * 验证订单状态是否合理
     *
     * @param refundInfoDTO
     * @param refundOperateIdEnum
     */
    protected void checkRefundOrderStatus(RefundInfoDTO refundInfoDTO, RefundOperateIdEnum refundOperateIdEnum) {
        switch (refundOperateIdEnum) {
            case SUBMIT:
                //订单状态为 初始 || 撤回 || 商家初步驳回 || 商家收货后驳回
                if (refundInfoDTO.getStatus() != null &&
                        !(RefundStatusEnum.WITHDRAW.getID().equals(refundInfoDTO.getStatus())) &&
                        !RefundStatusEnum.BUSINESS_REJECT.getID().equals(refundInfoDTO.getStatus()) &&
                        !RefundStatusEnum.BUSINESS_REJECT_WITH_COMMODITY.getID().equals(refundInfoDTO.getStatus())
                        ) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order can not submit");
                }
                break;
            case BUSINESS_PASS:
            case BUSINESS_REJECT:
                //订单状态为 提交
                if (!RefundStatusEnum.SUBMIT.getID().equals(refundInfoDTO.getStatus())) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order status must be submit");
                }
                break;
            case WITHDRAW:
                //订单状态为 提交 || 待邮寄 || 商家驳回
                if (!RefundStatusEnum.SUBMIT.getID().equals(refundInfoDTO.getStatus()) &&
                        !RefundStatusEnum.WAIT_SHIP.getID().equals(refundInfoDTO.getStatus()) &&
                        !RefundStatusEnum.BUSINESS_REJECT.getID().equals(refundInfoDTO.getStatus())
                        ) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order can not withdraw");
                }
                break;
            case SHIP_CONFIRM:
                //订单状态为 待邮寄
                if (!RefundStatusEnum.WAIT_SHIP.getID().equals(refundInfoDTO.getStatus())) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order must be wait ship");
                }
                break;
            case RECEIVE_CONFIRM:
                //订单状态为 确认发货
                if (!RefundStatusEnum.WAIT_RECEIVE_CONFIRM.getID().equals(refundInfoDTO.getStatus())) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order must be wait received");
                }
                break;
            case BUSINESS_REJECT_WITH_COMMODITY:
            case START_PAY_BACK:
                //订单状态为 已收货,待商品审核
                if (!RefundStatusEnum.RECEIVED_COMMODITY_WAIT_DEAL.getID().equals(refundInfoDTO.getStatus())) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order must be received and waiting approval");
                }
                break;
            case DONE_PAY_BACK:
                //订单状态为 已收货,待商品审核
                if (!RefundStatusEnum.WAIT_PAY_BACK.getID().equals(refundInfoDTO.getStatus())) {
                    throw new SystemException(ResultCode.REFUND_STATUS_ERROR, "Refund order must be received and waiting pay back");
                }
                break;
            default:
                break;
        }
    }

}
