package com.itk.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer id;

    /**
    * 用户id
    */
    private String userId;

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
    * 性别 0:女 1:男
    */
    private Integer gender;

    /**
    * 昵称
    */
    private String nickName;

    /**
    * 错误次数
    */
    private Integer passwdErrorTime;

    /**
    * 生日
    */
    private Date birthday;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 最后修改时间
    */
    private Date modifyDate;

    /**
    * 最后登陆时间
    */
    private Date lastloginDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getPasswdErrorTime() {
        return passwdErrorTime;
    }

    public void setPasswdErrorTime(Integer passwdErrorTime) {
        this.passwdErrorTime = passwdErrorTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Date getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(Date lastloginDate) {
        this.lastloginDate = lastloginDate;
    }
}