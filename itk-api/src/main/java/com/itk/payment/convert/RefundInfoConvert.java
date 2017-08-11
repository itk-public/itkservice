package com.itk.payment.convert;

import com.itk.payment.dto.RefundDetailDTO;
import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundDetailVO;
import com.itk.payment.model.RefundInfoVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundInfoConvert {
    public static RefundInfoDTO RefundInfoVOToDTO(RefundInfoVO refundInfoVO) {
        if (null == refundInfoVO) {
            return null;
        }
        List<RefundDetailDTO> refundDetailDTOList = new ArrayList<>();
        RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
        refundInfoDTO.setId(refundInfoVO.getId());
        refundInfoDTO.setOrderId(refundInfoVO.getOrderId());
        refundInfoDTO.setStatus(refundInfoVO.getStatus());
        refundInfoDTO.setCreateTime(refundInfoVO.getCreateTime());
        refundInfoDTO.setAddress(refundInfoVO.getAddress());
        refundInfoDTO.setCompleteTime(refundInfoVO.getCompleteTime());
        refundInfoDTO.setExpressCompany(refundInfoVO.getExpressCompany());
        refundInfoDTO.setExpressNo(refundInfoVO.getExpressNo());
        refundInfoDTO.setFlowId(refundInfoVO.getFlowId());
        refundInfoDTO.setPromotionStatus(refundInfoVO.getPromotionStatus());
        refundInfoDTO.setPurchaseId(refundInfoVO.getPurchaseId());
        refundInfoDTO.setReason(refundInfoVO.getReason());
        refundInfoDTO.setRejectReason(refundInfoVO.getRejectReason());
        refundInfoDTO.setRejectReasonReceived(refundInfoVO.getRejectReasonReceived());
        refundInfoDTO.setShopId(refundInfoVO.getShopId());
        refundInfoDTO.setRemark(refundInfoVO.getRemark());
        refundInfoDTO.setCreateBy(refundInfoVO.getCreateBy());
        refundInfoDTO.setRefundDetails(
                refundInfoVO.getRefundDetails()
                        .stream()
                        .map(RefundDetailConvert::RefundDetailVOToDTO)
                        .collect(Collectors.toList())
        );
        return refundInfoDTO;
    }

    public static RefundInfoVO RefundInfoDTOToVO(RefundInfoDTO refundInfoDTO) {
        if (null == refundInfoDTO) {
            return null;
        }
        RefundInfoVO refundInfoVO = new RefundInfoVO();
        refundInfoVO.setId(refundInfoDTO.getId());
        refundInfoVO.setOrderId(refundInfoDTO.getOrderId());
        refundInfoVO.setStatus(refundInfoDTO.getStatus());
        refundInfoVO.setCreateTime(refundInfoDTO.getCreateTime());
        refundInfoVO.setAddress(refundInfoDTO.getAddress());
        refundInfoVO.setCompleteTime(refundInfoDTO.getCompleteTime());
        refundInfoVO.setExpressCompany(refundInfoDTO.getExpressCompany());
        refundInfoVO.setExpressNo(refundInfoDTO.getExpressNo());
        refundInfoVO.setFlowId(refundInfoDTO.getFlowId());
        refundInfoVO.setPromotionStatus(refundInfoDTO.getPromotionStatus());
        refundInfoVO.setPurchaseId(refundInfoDTO.getPurchaseId());
        refundInfoVO.setReason(refundInfoDTO.getReason());
        refundInfoVO.setRejectReason(refundInfoDTO.getRejectReason());
        refundInfoVO.setRejectReasonReceived(refundInfoDTO.getRejectReasonReceived());
        refundInfoVO.setShopId(refundInfoDTO.getShopId());
        refundInfoVO.setRemark(refundInfoDTO.getRemark());
        refundInfoVO.setCreateBy(refundInfoDTO.getCreateBy());
        refundInfoVO.setRefundDetails(
                refundInfoDTO.getRefundDetails()
                        .stream()
                        .map(RefundDetailConvert::RefundDetailDTOToVO)
                        .collect(Collectors.toList())
        );
        return refundInfoVO;
    }
}
