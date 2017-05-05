package com.itk.payment.model;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {
    private Integer id;

    /**
    * 支付 id
    */
    private String purchaseId;

    /**
    * 支付类型(待定)
    */
    private Integer type;

    /**
    * 订单 id
    */
    private String orderId;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 支付金额
    */
    private BigDecimal amount;

    /**
    * 支付状态(0: 未支付, 1: 支付)
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

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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