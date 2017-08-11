package com.itk.payment.convert;

import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundFlow;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundFlowBeanConvert {
    public static RefundInfoDTO RefundFlowToDTO(RefundFlow refundFlow){
        RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
        if (refundFlow != null) {
            BeanUtils.copyProperties(refundFlow, refundInfoDTO);
        }
        return refundInfoDTO;
    }

    public static RefundFlow RefundInfoDTOToPO(RefundInfoDTO refundInfoDTO){
        RefundFlow refundFlow = new RefundFlow();
        if (refundInfoDTO != null) {
            BeanUtils.copyProperties(refundInfoDTO, refundFlow);
        }
        return refundFlow;
    }
}
