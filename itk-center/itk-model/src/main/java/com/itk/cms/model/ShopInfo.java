package com.itk.cms.model;

import java.io.Serializable;
import java.util.Date;

public class ShopInfo implements Serializable {
    private Long id;

    /**
    * 乡镇id
    */
    private Long townshipId;

    /**
    * 门店编码
    */
    private String shopCode;

    /**
    * 门店名称
    */
    private String shopName;

    /**
    * 具体地址
    */
    private String address;

    /**
    * 联系电话
    */
    private String phone;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 上线时间
    */
    private Date onlineTime;

    /**
    * 下线时间
    */
    private Date offlineTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后更新时间
    */
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTownshipId() {
        return townshipId;
    }

    public void setTownshipId(Long townshipId) {
        this.townshipId = townshipId;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
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
}