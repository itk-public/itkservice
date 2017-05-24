package com.itk.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserShippingAddress implements Serializable{
    private Integer id;

    /**
    * 用户ID
    */
    private String userId;

    /**
    * 收货人姓名
    */
    private String receiverName;

    /**
    * 收货人电话
    */
    private String receiverPhone;

    /**
    * 省ID
    */
    private Integer proviceId;

    /**
    * 地级市id
    */
    private Long cityId;

    /**
    * 县级市id
    */
    private Long countyId;

    /**
    * 镇id
    */
    private Long townId;

    /**
    * 村id
    */
    private Long villageId;

    /**
    * 详细地址
    */
    private String addressDetail;

    /**
    * 邮编
    */
    private String postCode;

    /**
    * 是否默认,0非,1是
    */
    private Boolean deefault;

    /**
    * 是否可用,1是,0非
    */
    private Boolean enable;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 最后更改人
    */
    private String lastModifyBy;

    /**
    * 最后修改时间
    */
    private Date lastModifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Integer getProviceId() {
        return proviceId;
    }

    public void setProviceId(Integer proviceId) {
        this.proviceId = proviceId;
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

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getDeefault() {
        return deefault;
    }

    public void setDeefault(Boolean deefault) {
        this.deefault = deefault;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}