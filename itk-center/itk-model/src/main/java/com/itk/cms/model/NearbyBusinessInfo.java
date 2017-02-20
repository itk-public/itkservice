package com.itk.cms.model;

import java.io.Serializable;
import java.util.Date;

public class NearbyBusinessInfo implements Serializable {
    private Long id;

    /**
    * 附近商家表的id
    */
    private Long nearbyBusinessId;

    /**
    * 是否有促销:1有促销 0无促销 如果有读取促销信息
    */
    private Integer whetherPromotion;

    /**
    * 是否显示月订单数量:1显示真实数量 0后台输入
    */
    private String whetherMonthOrderNumber;

    /**
    * 月订单数量
    */
    private Long monthOrderNumber;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

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

    public Long getNearbyBusinessId() {
        return nearbyBusinessId;
    }

    public void setNearbyBusinessId(Long nearbyBusinessId) {
        this.nearbyBusinessId = nearbyBusinessId;
    }

    public Integer getWhetherPromotion() {
        return whetherPromotion;
    }

    public void setWhetherPromotion(Integer whetherPromotion) {
        this.whetherPromotion = whetherPromotion;
    }

    public String getWhetherMonthOrderNumber() {
        return whetherMonthOrderNumber;
    }

    public void setWhetherMonthOrderNumber(String whetherMonthOrderNumber) {
        this.whetherMonthOrderNumber = whetherMonthOrderNumber;
    }

    public Long getMonthOrderNumber() {
        return monthOrderNumber;
    }

    public void setMonthOrderNumber(Long monthOrderNumber) {
        this.monthOrderNumber = monthOrderNumber;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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