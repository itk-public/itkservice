package com.itk.cms.model;

import java.io.Serializable;
import java.util.Date;

public class SeckillSeason implements Serializable {
    private Long id;

    /**
    * 名称
    */
    private String name;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 场次时间
    */
    private Date seasonTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getSeasonTime() {
        return seasonTime;
    }

    public void setSeasonTime(Date seasonTime) {
        this.seasonTime = seasonTime;
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