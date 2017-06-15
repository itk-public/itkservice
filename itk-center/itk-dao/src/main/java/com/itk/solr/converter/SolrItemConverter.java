package com.itk.solr.converter;

import com.itk.item.model.ItemInfo;
import com.itk.solr.model.SolrItem;
import org.springframework.beans.BeanUtils;

/**
 * Created by young on 2017/6/13.
 */
public class SolrItemConverter {

    public static SolrItem itemToSolrItem(ItemInfo itemInfo) {
        SolrItem solrItem = new SolrItem();
        if (itemInfo != null) {
            solrItem.setId(itemInfo.getId());
            solrItem.setName(itemInfo.getName());
            solrItem.setMainsrc(itemInfo.getMainsrc());
            solrItem.setBarCode(itemInfo.getBarCode());
            solrItem.setItemId(itemInfo.getItemId());
            solrItem.setDetailsrc(itemInfo.getDetailsrc());
            solrItem.setPrice(itemInfo.getPrice().doubleValue());
            solrItem.setCurrentPrice(itemInfo.getCurrentPrice() == null ? null : itemInfo.getCurrentPrice().doubleValue());
            solrItem.setHistoryPrice(itemInfo.getHistoryPrice() == null ? null : itemInfo.getHistoryPrice().doubleValue());
            solrItem.setPayPeriod(itemInfo.getPayPeriod());
            solrItem.setIsDel(itemInfo.getIsDel());
            solrItem.setStatus(itemInfo.getStatus());
            solrItem.setTotalStock(itemInfo.getTotalStock());
            solrItem.setCurrentStock(itemInfo.getCurrentStock());
            solrItem.setShopCategoryId(itemInfo.getShopCategoryId());
            solrItem.setShopId(itemInfo.getShopId());
            solrItem.setCategoryId(itemInfo.getCategoryId());
        }
        return solrItem;
    }
}
