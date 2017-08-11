package com.itk.payment.convert;

import com.itk.payment.dto.RefundDetailDTO;
import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundDetailVO;
import com.itk.payment.model.RefundInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundDetailConvert {
    public static RefundDetailDTO RefundDetailVOToDTO(RefundDetailVO refundDetailVO){
        RefundDetailDTO refundDetailDTO = new RefundDetailDTO();
        if (refundDetailVO != null) {
            BeanUtils.copyProperties(refundDetailVO, refundDetailDTO);
        }
        return refundDetailDTO;
    }

    public static RefundDetailVO RefundDetailDTOToVO(RefundDetailDTO refundDetailDTO){
        RefundDetailVO refundDetailVO = new RefundDetailVO();
        if (refundDetailDTO != null) {
            BeanUtils.copyProperties(refundDetailDTO, refundDetailVO);
        }
        return refundDetailVO;
    }
}
