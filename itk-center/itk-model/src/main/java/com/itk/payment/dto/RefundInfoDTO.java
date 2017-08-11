package com.itk.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 8/10/17.
 */
@Setter
@Getter
public class RefundInfoDTO {

    private Long id;

    private Integer type;                   //退款类型(0: 部分退款, 1: 整单退款)

    private String flowId;                  //refund flow Id

    private String purchaseId;              //支付 id

    private String orderId;

    private Long shopId;

    private Integer promotionStatus;        //退券状态(0: 未退, 1: 已退)

    private Integer status;                 //refund status enum

    private String reason;                  //退货理由

    private String address;                 //退货地址

    private String remark;                  //备注

    private String rejectReason;            //驳回理由

    private String rejectReasonReceived;    //收货后驳回理由

    private String expressCompany;          //快递公司

    private String expressNo;               //快递单号

    private Date createTime;

    private String createBy;

    private Date completeTime;

    private List<RefundDetailDTO> refundDetails;
}
