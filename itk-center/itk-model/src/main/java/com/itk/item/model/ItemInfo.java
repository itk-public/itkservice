package com.itk.item.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItemInfo implements Serializable {
    private Integer id;

    /**
    * 商品名称
    */
    private String name;

    /**
    * 商品主图
    */
    private String mainsrc;

    /**
    * 条形码
    */
    private String barCode;

    /**
    * 商品id
    */
    private String itemId;

    /**
    * 商品详情图
    */
    private String detailsrc;

    /**
    * 商品价格
    */
    private BigDecimal price;

    /**
    * 当前商品进价
    */
    private BigDecimal currentPrice;

    /**
    * 历史商品进价
    */
    private BigDecimal historyPrice;

    /**
    * 结算周期 每月15号或者月末最后一天结算）
    */
    private String payPeriod;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 商家类目id
    */
    private Integer shopCategoryId;

    /**
    * 商品总库存
    */
    private Integer totalStock;

    /**
    * 当前库存
    */
    private Integer currentStock;

    /**
    * 商家id
    */
    private Long shopId;

    /**
    * 分类类目
    */
    private Long categoryId;

    /**
    * 状态 1：有效 0：失效
    */
    private Integer status;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 创建人
    */
    private String creator;

    /**
    * 更新人
    */
    private String updator;

    /**
    * 最后更新时间
    */
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainsrc() {
        return mainsrc;
    }

    public void setMainsrc(String mainsrc) {
        this.mainsrc = mainsrc;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDetailsrc() {
        return detailsrc;
    }

    public void setDetailsrc(String detailsrc) {
        this.detailsrc = detailsrc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getHistoryPrice() {
        return historyPrice;
    }

    public void setHistoryPrice(BigDecimal historyPrice) {
        this.historyPrice = historyPrice;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}