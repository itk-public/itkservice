package com.itk.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by enchen on 8/10/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RefundHistoryVO {

    @NotNull
    private String refundFlowId;

    @NotNull
    private Integer operateId;              //操作类型id

    @NotNull
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
