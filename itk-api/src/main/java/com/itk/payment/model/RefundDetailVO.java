package com.itk.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by enchen on 8/10/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RefundDetailVO {

    private String refundDetailId;      //退款详情 id

    private String flowId;              //退款流水 id

    private String orderDetailId;       //订单明细 id   如是整单退,根据 refundFlow 中的 orderId 即可进行逻辑处理;
                                        //             如是部分退,将需退款的 orderDetailId 装载过来,进行逻辑处理;

    private Integer refundCount;        //退货数量

    private Integer platformPromotionCode;  //平台券id

    private Integer shopPromotionCode;      //商家券id
}
