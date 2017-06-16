package com.itk.item.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by enchen on 6/13/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class ItemInfoVO {
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品主图
     */
    private String mainsrc;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 商品详情图
     */
    private String detailsrc;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商家id
     */
    private Long shopId;
}
