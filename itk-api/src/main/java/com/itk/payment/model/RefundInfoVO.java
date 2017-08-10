package com.itk.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 8/10/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RefundInfoVO {

    @NotNull
    private Integer type;                   //退款类型(0: 部分退款, 1: 整单退款)

    private String flowId;                  //refund flow Id

    private String purchaseId;              //支付 id

    @NotNull
    private String orderId;

    private Long shopId;

    private String refundDetailId;

    private Integer promotionStatus;        //退券状态(0: 未退, 1: 已退)

    @NotNull
    private Integer status;                 //refund status enum

    @NotNull
    private String reason;                  //退货理由

    private String address;                 //退货地址

    private String remark;                  //备注

    private String rejectReason;            //驳回理由

    private String rejectReasonReceived;    //收货后驳回理由

    private String expressCompany;          //快递公司

    private String expressNo;               //快递单号

    private Date createTime;

    private Date completeTime;

    private List<RefundDetail> refundDetails;
}
