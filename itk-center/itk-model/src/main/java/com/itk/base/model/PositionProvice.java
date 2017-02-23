package com.itk.base.model;

import java.io.Serializable;

public class PositionProvice implements Serializable {
    /**
    * 主键ID
    */
    private Integer id;

    /**
    * 省份id、省份编号
    */
    private Integer proviceId;

    /**
    * 省份名称
    */
    private String proviceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviceId() {
        return proviceId;
    }

    public void setProviceId(Integer proviceId) {
        this.proviceId = proviceId;
    }

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }
}