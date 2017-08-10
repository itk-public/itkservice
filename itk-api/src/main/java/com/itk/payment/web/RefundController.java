package com.itk.payment.web;

import com.itk.payment.model.RefundInfoVO;
import com.itk.payment.service.RefundFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by enchen on 5/5/17.
 */
@Controller
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    RefundFrontServiceImpl refundFrontService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public WebResult addPurchase(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(refundFrontService.submitRefund(refundInfoVO));
    }

}
