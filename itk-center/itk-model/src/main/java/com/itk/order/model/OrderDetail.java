package com.itk.order.model;

import java.math.BigDecimal;

public class OrderDetail {
    private Long id;

    /**
    * 订单 id
    */
    private String orderId;

    /**
    * 商品信息 id
    */
    private String itemInfoId;

    /**
    * 商品购买数量
    */
    private Integer itemCount;

    /**
    * 运费 id
    */
    private Integer freightId;

    /**
    * 平台券id
    */
    private Integer platformPromotionCode;

    /**
    * 平台券使用金额
    */
    private BigDecimal platformPromotionCost;

    /**
    * 商家券 id
    */
    private Integer shopPromotionCode;

    /**
    * 商家券使用金额
    */
    private BigDecimal shopPromotionCost;

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

    public String getItemInfoId() {
        return itemInfoId;
    }

    public void setItemInfoId(String itemInfoId) {
        this.itemInfoId = itemInfoId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Integer getPlatformPromotionCode() {
        return platformPromotionCode;
    }

    public void setPlatformPromotionCode(Integer platformPromotionCode) {
        this.platformPromotionCode = platformPromotionCode;
    }

    public BigDecimal getPlatformPromotionCost() {
        return platformPromotionCost;
    }

    public void setPlatformPromotionCost(BigDecimal platformPromotionCost) {
        this.platformPromotionCost = platformPromotionCost;
    }

    public Integer getShopPromotionCode() {
        return shopPromotionCode;
    }

    public void setShopPromotionCode(Integer shopPromotionCode) {
        this.shopPromotionCode = shopPromotionCode;
    }

    public BigDecimal getShopPromotionCost() {
        return shopPromotionCost;
    }

    public void setShopPromotionCost(BigDecimal shopPromotionCost) {
        this.shopPromotionCost = shopPromotionCost;
    }
}