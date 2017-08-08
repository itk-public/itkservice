package com.itk.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.itk.item.model.ItemInfo;
import com.itk.promotion.model.SaleInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by enchen on 6/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class OrderInfoVO {

    /**
     *  收货地址 id
     */
    @NotNull
    private Integer addressId;

    @NotNull
    private List<OrderShopDetail> orderList;

    private allocationTime allocationTime;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class allocationTime {

        private Timestamp date;
        private String allocationFromTime;
        private String allocationToTime;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class OrderShopDetail {
        private String orderId;
        private List<Product> products;
        private Long shopId;
        private Integer couponId;
        @JsonIgnore
        private SaleInfo saleInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class Product {
        private Integer itemId;
        private Integer number;
        @JsonIgnore
        private ItemInfo itemInfo;
    }
    private Integer platformCouponId;

    /**
     * 配送方式(0: 平台配送, 1: 用户自提)
     */
    @NotNull
    private Integer allocationType;

    private Integer pickSelfLocationId;
}
