package com.itk.back.model;

import java.io.Serializable;
import java.util.Date;

public class BackUser implements Serializable {
    private Integer id;

    /**
    * 账号
    */
    private String username;

    /**
    * 姓名
    */
    private String name;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 密码
    */
    private String password;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 删除状态 0:正常 1:删除
    */
    private Integer isDel;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 最后登陆时间
    */
    private Date lastloginDate;

    /**
    * 最后更新时间
    */
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(Date lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}