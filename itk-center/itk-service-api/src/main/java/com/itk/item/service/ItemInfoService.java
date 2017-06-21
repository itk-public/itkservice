package com.itk.item.service;


import com.itk.item.model.ItemInfo;
import com.itk.solr.model.SolrItem;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public interface ItemInfoService {

    int addItemInfo(ItemInfo itemInfo);

    int updateItemInfo(ItemInfo itemInfo);

    int delItemInfo(Integer id);

    ItemInfo selectByPrimaryKey(Integer id);

    ItemInfo selectByItemId(String itemId);

    List<ItemInfo> selectByCategoryIdAndStatus(Long categoryId, Integer status);

    List<ItemInfo> selectByShopIdAndStatus(Long shopId, Integer status);

    List<ItemInfo> selectByShopCategoryIdAndStatus(Integer shopCategoryId, Integer status);

    PageInfo<SolrItem> selectSolrItemByKeyword(String keyword, PageParam pageParam);
}
