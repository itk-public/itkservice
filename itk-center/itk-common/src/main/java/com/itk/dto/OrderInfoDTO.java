package com.itk.dto;

import com.itk.item.model.ItemInfo;
import com.itk.promotion.model.SaleInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by enchen on 6/20/17.
 */
@Setter
@Getter
public class OrderInfoDTO {
    /**
     *  收货地址 id
     */
    private Integer addressId;

    private List<OrderShopDetail> orderList;

    private allocationTime allocationTime;

    private BigDecimal actualTotalAmount;

    @Setter
    @Getter
    public static class allocationTime {

        private Timestamp date;
        private String allocationFromTime;
        private String allocationToTime;
    }

    @Setter
    @Getter
    public static class OrderShopDetail {
        private String orderId;
        private List<Product> products;
        private Long shopId;
        private Integer couponId;
        private SaleInfo saleInfo;
        private BigDecimal actualAmount;
    }

    @Setter
    @Getter
    public static class Product {
        private Integer itemId;
        private Integer number;
        private ItemInfo itemInfo;
        private BigDecimal actualPrice;
    }
    private Integer platformCouponId;

    /**
     * 配送方式(0: 平台配送, 1: 用户自提)
     */
    private Integer allocationType;

    private Integer pickSelfLocationId;
}
