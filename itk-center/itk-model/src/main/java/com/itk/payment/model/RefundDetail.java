package com.itk.payment.model;

public class RefundDetail {
    private Long id;

    /**
    * 退款详情 id
    */
    private String refundDetailId;

    /**
    * 流水 id
    */
    private String flowId;

    /**
    * 商品信息 id
    */
    private String itemInfoId;

    /**
    * 退货数量
    */
    private Integer refundCount;

    /**
    * 平台券id
    */
    private Integer platformPromotionCode;

    /**
    * 商家券 id
    */
    private Integer shopPromotionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundDetailId() {
        return refundDetailId;
    }

    public void setRefundDetailId(String refundDetailId) {
        this.refundDetailId = refundDetailId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getItemInfoId() {
        return itemInfoId;
    }

    public void setItemInfoId(String itemInfoId) {
        this.itemInfoId = itemInfoId;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public Integer getPlatformPromotionCode() {
        return platformPromotionCode;
    }

    public void setPlatformPromotionCode(Integer platformPromotionCode) {
        this.platformPromotionCode = platformPromotionCode;
    }

    public Integer getShopPromotionCode() {
        return shopPromotionCode;
    }

    public void setShopPromotionCode(Integer shopPromotionCode) {
        this.shopPromotionCode = shopPromotionCode;
    }
}