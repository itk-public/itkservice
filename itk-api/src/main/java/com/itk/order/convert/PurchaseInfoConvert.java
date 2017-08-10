package com.itk.order.convert;

import com.itk.payment.dto.PurchaseInfoDTO;
import com.itk.order.model.PurchaseInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class PurchaseInfoConvert {
    public static PurchaseInfoDTO PurchaseInfoVOToDTO(PurchaseInfoVO purchaseInfoVO){
        PurchaseInfoDTO purchaseInfoDTO = new PurchaseInfoDTO();
        if (purchaseInfoVO != null) {
            BeanUtils.copyProperties(purchaseInfoVO, purchaseInfoDTO);
        }
        return purchaseInfoDTO;
    }

    public static PurchaseInfoVO PurchaseInfoDTOToVO(PurchaseInfoDTO purchaseInfoDTO){
        PurchaseInfoVO purchaseInfoVO = new PurchaseInfoVO();
        if (purchaseInfoDTO != null) {
            BeanUtils.copyProperties(purchaseInfoDTO, purchaseInfoVO);
        }
        return purchaseInfoVO;
    }
}
