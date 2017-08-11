package com.itk.payment.service;

import com.itk.payment.dto.RefundInfoDTO;

/**
 * Created by enchen on 8/10/17.
 */
public interface RefundProcessService {
    RefundInfoDTO submitRefund(RefundInfoDTO refundInfoDTO);
}
