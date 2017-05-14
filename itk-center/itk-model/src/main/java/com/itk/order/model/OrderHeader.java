package com.itk.order.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderHeader {
    private Long id;

    /**
    * 订单 id
    */
    private String orderId;

    /**
    * 订单状态(1 = 待支付, 2 = 商品打包中, 3 = 配送中, 4 = 待自提, 5 = 已签收, 6 = 订单完成, 7 = 订单取消, 8 = 退款审核中, 9 = 退货审核中)
    */
    private Integer status;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 过期状态 0:正常 1:过期
    */
    private Integer isExpired;

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
    * 配送起始时间
    */
    private Date allocationFromTime;

    /**
    * 配送到达时间
    */
    private Date allocationToTime;

    /**
    * 配送方式(0: 平台配送, 1: 用户自提)
    */
    private Integer allocationType;

    /**
    * 备注
    */
    private String comment;

    /**
    * 送达时间
    */
    private Date arrivalTime;

    /**
    * 完成时间
    */
    private Date completeTime;

    /**
    * 下单时间
    */
    private Date createTime;

    /**
    * 最后更新时间
    */
    private Date modifyTime;

    /**
    * 创建人
    */
    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Date getAllocationFromTime() {
        return allocationFromTime;
    }

    public void setAllocationFromTime(Date allocationFromTime) {
        this.allocationFromTime = allocationFromTime;
    }

    public Date getAllocationToTime() {
        return allocationToTime;
    }

    public void setAllocationToTime(Date allocationToTime) {
        this.allocationToTime = allocationToTime;
    }

    public Integer getAllocationType() {
        return allocationType;
    }

    public void setAllocationType(Integer allocationType) {
        this.allocationType = allocationType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}