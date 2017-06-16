package com.itk.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.itk.base.model.ShopInfo;
import com.itk.item.model.ItemInfo;
import com.itk.item.model.ItemInfoVO;
import com.itk.promotion.model.SaleInfo;
import com.itk.user.model.UserShippingAddress;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by enchen on 6/2/17.
 *
 * 购物车到订单结算页数据
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class ShoppingCartVO {

    /**
     * 订单 id
     */
    private String orderId;

    /**
     * 订单状态(1 = 待支付, 2 = 商品打包中, 3 = 配送中, 4 = 待自提, 5 = 已签收, 6 = 订单完成, 7 = 订单取消, 8 = 退款审核中, 9 = 退货审核中)
     */
    private Integer status;

    /**
     * 地址信息 id
     */
    private Integer addressId;

    /**
     * 实际支付金额
     */
    private BigDecimal actualAmount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 配送方式(0: 平台配送, 1: 用户自提)
     */
    private Integer allocationType;

    /**
     * 是否有平台券
     */
    private Boolean platformCoupon;

    private ReceiveInfo receiveInfo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class ReceiveInfo {

        private UserShippingAddress userShippingAddress;

        private ShopInfo shopInfo;
    }

    private SaleInfo saleInfo;//券信息

    private List<ShopDetail> shopList;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class ShopDetail {

        private Long shopId;

        private ShopInfo shop;

        private BigDecimal marketTotal;

        private BigDecimal actualTotal;

        private SaleInfo coupon;

        private List<ProductDetail> products;

        private boolean withCoupon;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class ProductDetail {

        private Integer itemId;
        private ItemInfoVO itemInfo;
        private Price price;
        private Integer number;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public static class Price {
        private BigDecimal market;
        private BigDecimal actual;
    }
    //todo
    //appointments
    //allocationType

}
