package com.itk.user.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserShippingAddress implements Serializable{
    private Integer id;

    /**
    * 用户ID
    */
    private String userId;

    /**
    * 收货人姓名
    */
    private String receiverName;

    /**
    * 收货人电话
    */
    private String receiverPhone;

    /**
    * 省ID
    */
    private Integer proviceId;

    /**
    * 地级市id
    */
    private Long cityId;

    /**
    * 县级市id
    */
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
    private boolean deefault;

    /**
    * 是否可用,1是,0非
    */
    private boolean enable;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 最后更改人
    */
    private String lastModifyBy;

    /**
    * 最后修改时间
    */
    private Date lastModifyDate;

}