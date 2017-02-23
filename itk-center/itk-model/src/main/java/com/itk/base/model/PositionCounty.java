package com.itk.base.model;

import java.io.Serializable;

public class PositionCounty implements Serializable {
    /**
    * 地级市主键ID
    */
    private Integer id;

    /**
    * 地级市id
    */
    private Long cityId;

    /**
    * 县级id
    */
    private Long countyId;

    private String countyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}