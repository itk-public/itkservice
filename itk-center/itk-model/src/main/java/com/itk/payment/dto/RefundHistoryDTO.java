package com.itk.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by enchen on 8/10/17.
 */
@Getter
@Setter
public class RefundHistoryDTO {

    private String refundFlowId;

    private Integer operateId;              //操作类型id

    private Integer operatorTypeId;         //操作者类型

    private String operateDetail;           //操作内容

    private String comment;

    private Long operatorId;

    private String operatorName;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}
