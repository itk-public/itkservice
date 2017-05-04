package com.itk.user.model;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
    private Integer id;

    /**
    * 会员 id
    */
    private String memberId;

    /**
    * 用户 id
    */
    private Integer userId;

    /**
    * 会员等级(0 普通会员)
    */
    private Integer level;

    /**
    * 余额
    */
    private BigDecimal balance;

    /**
    * 是否可用(0 不可用, 1 可用)
    */
    private Integer isDel;

    /**
    * 创建时间
    */
    private Date createDate;

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}