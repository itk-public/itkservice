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
     * 退款状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 完成时间
     */
    private Date completeTime;

    /**
     * 退货理由
     */
    private String reason;

    /**
     * 退货地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 驳回理由
     */
    private String rejectReason;

    /**
     * 收货后驳回理由
     */
    private String rejectReasonReceived;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 快递单号
     */
    private String expressNo;

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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getRejectReasonReceived() {
        return rejectReasonReceived;
    }

    public void setRejectReasonReceived(String rejectReasonReceived) {
        this.rejectReasonReceived = rejectReasonReceived;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}