package com.itk.payment.service;

import com.itk.exception.SystemException;
import com.itk.payment.convert.RefundInfoConvert;
import com.itk.payment.dto.RefundInfoDTO;
import com.itk.payment.model.RefundInfoVO;
import com.itk.security.SecurityUtils;
import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoService;
import com.itk.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class RefundFrontServiceImpl {

    @Autowired
    RefundProcessService refundProcessService;

    @Autowired
    UserInfoService userInfoService;

    public RefundInfoDTO submitRefund(RefundInfoVO refundInfoVO){
        if(null == refundInfoVO.getOrderId()){
            throw new SystemException(ResultCode.REFUND_ORDER_UNKNOWN, "Refund Order Required");
        }
        if(null == refundInfoVO.getReason()){
            throw new SystemException(ResultCode.REFUND_REASON_REQUIRED, "Refund Reason Required");
        }
        refundInfoVO.getRefundDetails()
                .stream()
                .map(refundDetailVO -> {
                    if(null == refundDetailVO.getOrderDetailId()){
                        throw new SystemException(ResultCode.REFUND_ORDER_DETAIL_UNKNOWN, "Refund Order Detail Required");
                    }
                    return refundDetailVO;
                })
                .collect(Collectors.toList());
        String login = SecurityUtils.getCurrentUserLogin();
        UserInfo userInfo = userInfoService.findUserByPhone(login);
        refundInfoVO.setCreateBy(userInfo.getUserId());
        RefundInfoDTO refundInfoDTO = RefundInfoConvert.RefundInfoVOToDTO(refundInfoVO);
        return refundProcessService.submitRefund(refundInfoDTO);
    }

}
