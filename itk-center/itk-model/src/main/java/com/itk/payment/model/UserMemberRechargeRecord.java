package com.itk.payment.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserMemberRechargeRecord {
    private Integer id;

    /**
    * 会员id
    */
    private String memberId;

    /**
    * 冲值金额
    */
    private BigDecimal rechargeAmount;

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

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
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