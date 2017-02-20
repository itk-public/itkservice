package com.itk.cms.model;

import java.io.Serializable;
import java.util.Date;

public class PageSort implements Serializable {
    private Long id;

    /**
    * 显示位置
    */
    private Integer sortId;

    /**
    * 主页id
    */
    private Long homePageId;

    /**
    * 组件信息定位组件表例如：hbanner --》t_hbanner表
    */
    private String assemblyName;

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

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Long getHomePageId() {
        return homePageId;
    }

    public void setHomePageId(Long homePageId) {
        this.homePageId = homePageId;
    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
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