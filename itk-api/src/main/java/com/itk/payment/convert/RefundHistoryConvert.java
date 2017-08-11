package com.itk.payment.convert;

import com.itk.payment.dto.RefundDetailDTO;
import com.itk.payment.dto.RefundHistoryDTO;
import com.itk.payment.model.RefundDetailVO;
import com.itk.payment.model.RefundHistory;
import com.itk.payment.model.RefundHistoryVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundHistoryConvert {
    public static RefundHistoryDTO RefundHistoryVOToDTO(RefundHistoryVO refundHistoryVO){
        RefundHistoryDTO refundHistoryDTO = new RefundHistoryDTO();
        if (refundHistoryVO != null) {
            BeanUtils.copyProperties(refundHistoryVO, refundHistoryDTO);
        }
        return refundHistoryDTO;
    }

    public static RefundHistoryVO RefundHistoryDTOToVO(RefundHistoryDTO refundHistoryDTO){
        RefundHistoryVO refundHistoryVO = new RefundHistoryVO();
        if (refundHistoryDTO != null) {
            BeanUtils.copyProperties(refundHistoryDTO, refundHistoryVO);
        }
        return refundHistoryVO;
    }
}
