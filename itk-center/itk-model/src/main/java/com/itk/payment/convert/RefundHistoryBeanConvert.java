package com.itk.payment.convert;

import com.itk.payment.dto.RefundHistoryDTO;
import com.itk.payment.model.RefundHistory;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundHistoryBeanConvert {
    public static RefundHistoryDTO RefundHistoryToDTO(RefundHistory refundHistory){
        RefundHistoryDTO refundHistoryDTO = new RefundHistoryDTO();
        if (refundHistory != null) {
            BeanUtils.copyProperties(refundHistory, refundHistoryDTO);
        }
        return refundHistoryDTO;
    }

    public static RefundHistory RefundHistoryDTOToPO(RefundHistoryDTO refundHistoryDTO){
        RefundHistory refundHistory = new RefundHistory();
        if (refundHistoryDTO != null) {
            BeanUtils.copyProperties(refundHistoryDTO, refundHistory);
        }
        return refundHistory;
    }
}
