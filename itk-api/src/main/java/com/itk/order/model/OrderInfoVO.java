package com.itk.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by enchen on 6/2/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class OrderInfoVO {

    /**
     * 订单 id
     */
    private String orderId;

    /**
     * 订单状态(1 = 待支付, 2 = 商品打包中, 3 = 配送中, 4 = 待自提, 5 = 已签收, 6 = 订单完成, 7 = 订单取消, 8 = 退款审核中, 9 = 退货审核中)
     */
    private Integer status;

    /**
     * 地址信息 id
     */
    private String addressId;

    /**
     * 实际支付金额
     */
    private BigDecimal actualAmount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     *  店铺信息 id
     */
    private String shopId;

    /**
     * 配送方式(0: 平台配送, 1: 用户自提)
     */
    private Integer allocationType;

    private ReceiveInfo receiveInfo;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiveInfo{

        private
    }
    //todo
    //appointments

}
