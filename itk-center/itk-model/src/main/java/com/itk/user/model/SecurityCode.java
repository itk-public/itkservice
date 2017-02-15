package com.itk.user.model;

import java.io.Serializable;
import java.util.Date;

public class SecurityCode implements Serializable {
    private Integer id;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 验证码
    */
    private String securityCode;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 修改时间
    */
    private Date modifyDate;

    /**
    * 状态 1：有效 0：失效
    */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}