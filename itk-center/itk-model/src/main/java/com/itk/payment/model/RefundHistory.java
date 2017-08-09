package com.itk.payment.model;

import java.util.Date;

public class RefundHistory {
    /**
    * 主键
    */
    private Long id;

    /**
    * 业务单据id
    */
    private String refundFlowId;

    /**
    * 操作类型id
    */
    private Integer operateId;

    /**
    * 操作方类型
    */
    private Integer operatorTypeId;

    /**
    * 操作内容
    */
    private String operateDetail;

    /**
    * 备注
    */
    private String comment;

    /**
    * 创建人
    */
    private Long createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改人
    */
    private Long updateBy;

    /**
    * 更新时间
    */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundFlowId() {
        return refundFlowId;
    }

    public void setRefundFlowId(String refundFlowId) {
        this.refundFlowId = refundFlowId;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Integer getOperatorTypeId() {
        return operatorTypeId;
    }

    public void setOperatorTypeId(Integer operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    public String getOperateDetail() {
        return operateDetail;
    }

    public void setOperateDetail(String operateDetail) {
        this.operateDetail = operateDetail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}