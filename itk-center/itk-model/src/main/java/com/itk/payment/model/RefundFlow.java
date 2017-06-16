package com.itk.payment.model;

import java.util.Date;

public class RefundFlow {
    private Integer id;

    /**
    * 流水 id
    */
    private String flowId;

    /**
    * 支付 id
    */
    private String purchaseId;

    /**
    * 订单 id
    */
    private String orderId;

    /**
    *  店铺信息 id
    */
    private Long shopId;

    /**
    * 退款明细 id
    */
    private String refundDetailId;

    /**
    * 退款类型(0: 部分退款, 1: 整单退款)
    */
    private Integer type;

    /**
    * 退券状态(0: 未退, 1: 已退)
    */
    private Integer promotionStatus;

    /**
    * 退款状态(0: 未退款, 1: 已退款)
    */
    private Integer status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 完成时间
    */
    private Date completeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getRefundDetailId() {
        return refundDetailId;
    }

    public void setRefundDetailId(String refundDetailId) {
        this.refundDetailId = refundDetailId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(Integer promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }
}