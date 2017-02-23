package com.itk.base.model;

import java.io.Serializable;

public class PositionVillage implements Serializable {
    private Integer id;

    /**
    * 镇id
    */
    private Long townId;

    /**
    * 村id--唯一
    */
    private Long villageId;

    private String villageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}