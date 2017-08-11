package com.itk.payment.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by enchen on 8/10/17.
 */
@Setter
@Getter
public class RefundDetailDTO {

    private Long id;

    private String refundDetailId;      //退款详情 id

    private String flowId;              //退款流水 id

    private Long orderDetailId;       //订单明细 id

    private Integer refundCount;        //退货数量

    private Integer platformPromotionCode;  //平台券id

    private Integer shopPromotionCode;      //商家券id
}
