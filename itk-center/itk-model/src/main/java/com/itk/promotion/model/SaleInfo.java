package com.itk.promotion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleInfo implements Serializable{
    private Integer id;

    /**
    * 促销券号
    */
    private String saleNumber;

    /**
    * 券代码
    */
    private String code;

    /**
    * 券名称
    */
    private String name;

    /**
    * 促销类型 （满减 现金券）
    */
    private Integer saleType;

    /**
    * 是否平台或者商家
    */
    private Integer type;

    /**
    * 打折标签 （本店满xx元使用）
    */
    private String tag;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 券生效时间
    */
    private Date effectiveDate;

    /**
    * 券过期时间
    */
    private Date invalidDate;

    /**
    * 创建人
    */
    private String creator;

    /**
    * 更新人
    */
    private String updator;

    /**
    * 优先级
    */
    private Long priority;

    /**
    * 券总数
    */
    private Integer totalTicket;

    /**
    * 券领取数量
    */
    private Integer usedTicket;

    /**
    * 券金额
    */
    private BigDecimal amount;

    /**
     * 当如果是满减券需要判断当前订单是否满足当前金额
     */
    private BigDecimal saleAmount;


    /**
    * 市id
    */
    private Long cityId;

    /**
    * 县id
    */
    private Long countyId;

    /**
    * 乡镇id
    */
    private Long townId;

    /**
    * 商家id
    */
    private String shopId;

    /**
    * 创建时间
    */
    private Date createDate;

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

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
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

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Integer getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(Integer totalTicket) {
        this.totalTicket = totalTicket;
    }

    public Integer getUsedTicket() {
        return usedTicket;
    }

    public void setUsedTicket(Integer usedTicket) {
        this.usedTicket = usedTicket;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}