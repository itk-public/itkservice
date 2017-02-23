package com.itk.base.model;

import java.io.Serializable;

public class PositionTown implements Serializable {
    private Integer id;

    /**
    * 县级市id
    */
    private Long countyId;

    /**
    * 镇id
    */
    private Long townId;

    private String townName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}