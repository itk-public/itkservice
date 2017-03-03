package com.itk.item.model;

import java.io.Serializable;
import java.util.Date;

public class ItemComment implements Serializable {
    private Integer id;

    /**
    * 商品id
    */
    private String itemId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 好评度 1：一星 2：二星 3：三星 4：四星 5：五星
    */
    private Integer rate;

    /**
    * 评价信息
    */
    private String comment;

    /**
    * 状态 1：有效 0：失效
    */
    private Integer status;

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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