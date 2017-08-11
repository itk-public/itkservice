package com.itk.payment.service.impl;

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
import com.itk.payment.model.Purchase;
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
    public RefundInfoDTO submitRefund(RefundInfoDTO refundInfoDTO) {
        //验证订单状态
        checkRefundOrderStatus(refundInfoDTO, RefundOperateIdEnum.SUBMIT);
        //添加退款历史
        refundHistoryService.addRefundSubmitHistory(refundInfoDTO.getFlowId(), null, refundInfoDTO.getCreateBy());
        //加载 orderHeader
        OrderHeader orderHeader = orderHeaderService.selectByOrderId(refundInfoDTO.getOrderId());
        if (null == orderHeader) {
            throw new SystemException(ResultCode.REFUND_ORDER_UNKNOWN, "Refund Order Required");
        }

        //插入 submit refund
        String flowId = OrderIdUtil.refundFlowIDGenerator();
        RefundFlow refundFlow = new RefundFlow();
        refundFlow.setFlowId(flowId);
        refundFlow.setOrderId(refundInfoDTO.getOrderId());
        refundFlow.setShopId(orderHeader.getShopId());
        refundFlow.setType(0);//退款类型(0: 部分退款, 1: 整单退款)
        refundFlow.setPromotionStatus(0);//退券状态(0: 未退, 1: 已退)
        refundFlow.setStatus(RefundStatusEnum.SUBMIT.getID());
        refundFlow.setCreateTime(new Date());
        refundFlow.setCreateBy(refundInfoDTO.getCreateBy());
        refundFlow.setReason(refundInfoDTO.getReason());
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
        return refundInfoDTOBack;
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
