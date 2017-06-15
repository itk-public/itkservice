package com.itk.solr.model;

import com.itk.base.model.ShopInfo;
import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ShopCategory;
import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by young on 2017/6/7.
 */
@SolrDocument
@Setter
@Getter
public class SolrItem implements Serializable {

    @Id
    @Field
    private Integer id;

    /**
     * 商品名称
     */
    @Field("item_name_txt_py")
    private String name;

    /**
     * 商品主图
     */
    @Field("item_main_src_s")
    private String mainsrc;

    /**
     * 条形码
     */
    @Field("item_bar_code_s")
    private String barCode;

    /**
     * 商品id
     */
    @Field("item_id_s")
    private String itemId;

    /**
     * 商品详情图
     */
    @Field("item_detail_src_s")
    private String detailsrc;

    /**
     * 商品价格
     */
    @Field("item_price_d")
    private Double price;

    /**
     * 当前商品进价
     */
    @Field("item_current_price_d")
    private Double currentPrice;

    /**
     * 历史商品进价
     */
    @Field("item_history_price_d")
    private Double historyPrice;

    /**
     * 结算周期 每月15号或者月末最后一天结算）
     */
    @Field("item_pay_period_s")
    private String payPeriod;

    /**
     * 删除状态 0:正常 1:删除
     */
    @Field("item_is_del_i")
    private Integer isDel;

    /**
     * 商家类目id
     */
    @Field("item_shop_category_id_i")
    private Integer shopCategoryId;

    //商家类目信息
    @Field(value = "item_shop_category_txt_py")
    @Indexed
    private String shopCategory;

    /**
     * 商品总库存
     */
    @Field("item_total_stock_i")
    private Integer totalStock;

    /**
     * 当前库存
     */
    @Field("item_current_stock_i")
    private Integer currentStock;

    /**
     * 商家id
     */
    @Field("item_shop_id_l")
    private Long shopId;

    //商家信息
    @Field(value = "item_shop_info_txt_py")
    @Indexed
    private String shopInfo;

    /**
     * 分类类目
     */
    @Field("item_category_id_l")
    private Long categoryId;

    //商品分类信息
    @Field(value = "item_category_txt_py")
    @Indexed
    private String category;

    /**
     * 状态 1：有效 0：失效
     */
    @Field("item_status_i")
    private Integer status;

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory.getName();
    }

    public void setShopInfo(ShopInfo shopInfo) {
        this.shopInfo = shopInfo.getShopCode() + " " + shopInfo.getShopName() + " " + shopInfo.getAddress();
    }

    public void setCategory(DisplayCategory category) {
        this.category = category.getName();
    }
}
