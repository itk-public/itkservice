package com.itk.user.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    /**
    * 内部userid
    */
    private String userid;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 手机
    */
    private String phone;

    /**
    * 名字
    */
    private String name;

    /**
    * 登陆错误次数
    */
    private Integer passwderrortime;

    /**
    * 生日
    */
    private Date birthday;

    /**
    * 创建时间
    */
    private Date createdate;

    /**
    * 修改时间
    */
    private Date modifydate;

    /**
    * 最后登陆时间
    */
    private Date lastlogindate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPasswderrortime() {
        return passwderrortime;
    }

    public void setPasswderrortime(Integer passwderrortime) {
        this.passwderrortime = passwderrortime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }
}