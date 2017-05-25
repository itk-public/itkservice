package com.itk.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by young on 2017/5/21.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class UserShippingAddressVO {

    private Integer id;

    /**
     * 用户ID
     */
    @NotNull
    private String userId;

    /**
     * 收货人姓名
     */
    @NotNull
    private String receiverName;

    /**
     * 收货人电话
     */
    @NotNull
    private String receiverPhone;

    /**
     * 省ID
     */
    @NotNull
    private Integer proviceId;

    /**
     * 地级市id
     */
    @NotNull
    private Long cityId;

    /**
     * 县级市id
     */
    @NotNull
    private Long countyId;

    /**
     * 镇id
     */
    private Long townId;

    /**
     * 村id
     */
    private Long villageId;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 是否默认,0非,1是
     */
    private boolean deefault = false;

    /**
     * 是否可用,1是,0非
     */
    private boolean enable = true;

}
