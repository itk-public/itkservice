package com.itk.payment.service;

import com.itk.payment.model.RefundInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class RefundFrontServiceImpl {

    @Autowired
    RefundDetailService refundDetailService;

    @Autowired
    RefundFlowService refundFlowService;

    public RefundInfoVO submitRefund(RefundInfoVO refundInfoVO){
        return null;
    }

}
