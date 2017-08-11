package com.itk.payment.convert;

import com.itk.payment.dto.RefundDetailDTO;
import com.itk.payment.model.RefundDetail;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class RefundDetailBeanConvert {
    public static RefundDetailDTO RefundDetailToDTO(RefundDetail refundDetail){
        RefundDetailDTO refundDetailDTO = new RefundDetailDTO();
        if (refundDetail != null) {
            BeanUtils.copyProperties(refundDetail, refundDetailDTO);
        }
        return refundDetailDTO;
    }

    public static RefundDetail RefundDetailDTOToPO(RefundDetailDTO refundDetailDTO){
        RefundDetail refundDetail = new RefundDetail();
        if (refundDetailDTO != null) {
            BeanUtils.copyProperties(refundDetailDTO, refundDetail);
        }
        return refundDetail;
    }
}
