package com.itk.base.model;

import java.io.Serializable;

public class PositionProvince implements Serializable {
    /**
    * 主键ID
    */
    private Integer id;

    /**
    * 省份id、省份编号
    */
    private Integer provinceId;

    /**
    * 省份名称
    */
    private String provinceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}