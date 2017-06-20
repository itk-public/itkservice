package com.itk.item.model;

import java.io.Serializable;
import java.util.Date;

public class DisplayCategory implements Serializable {
    private Long id;

    /**
    * 父类id
    */
    private Long parentId;

    /**
    * 名称
    */
    private String name;

    /**
    * 图片
    */
    private String src;

    /**
    * 是否显示 0:不显示 1:显示
    */
    private Integer isshow;

    /**
    * 是否叶子类目 0:不是 1:是
    */
    private Integer isLeafCategory;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    public Integer getIsLeafCategory() {
        return isLeafCategory;
    }

    public void setIsLeafCategory(Integer isLeafCategory) {
        this.isLeafCategory = isLeafCategory;
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