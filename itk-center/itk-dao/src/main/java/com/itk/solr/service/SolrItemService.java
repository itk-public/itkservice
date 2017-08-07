package com.itk.solr.service;

import com.itk.base.mapper.ShopInfoMapper;
import com.itk.base.model.ShopInfo;
import com.itk.item.convert.DisplayCategoryMapper;
import com.itk.item.convert.ShopCategoryMapper;
import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ItemInfo;
import com.itk.item.model.ShopCategory;
import com.itk.solr.converter.SolrItemConverter;
import com.itk.solr.model.SolrItem;
import com.itk.solr.repository.SolrItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by young on 2017/6/7.
 */
@Service
public class SolrItemService {

    private static final Logger log = LoggerFactory.getLogger(SolrItemService.class);

    @Autowired
    SolrItemRepository solrItemRepository;

    @Autowired
    ShopCategoryMapper shopCategoryMapper;

    @Autowired
    ShopInfoMapper shopInfoMapper;

    @Autowired
    DisplayCategoryMapper categoryMapper;

    /**
     * 存储商品信息时添加搜索信息
     *
     * @param itemInfo
     * @return
     */
    @Transactional
    public SolrItem saveItemInfo(ItemInfo itemInfo) {
        ShopCategory shopCategory = shopCategoryMapper.selectByPrimaryKey(itemInfo.getShopCategoryId());
        ShopInfo shopInfo = shopInfoMapper.selectByPrimaryKey(itemInfo.getShopId());
        DisplayCategory category = categoryMapper.selectByPrimaryKey(itemInfo.getCategoryId());
        SolrItem solrItem = SolrItemConverter.itemToSolrItem(itemInfo);
        solrItem.setShopCategory(shopCategory);
        solrItem.setShopInfo(shopInfo);
        solrItem.setCategory(category);
        return solrItemRepository.save(solrItem);
    }

    /**
     * 删除商品索引
     *
     * @param itemInfo
     */
    public void deleteItemInfo(ItemInfo itemInfo) {
        solrItemRepository.delete(itemInfo.getId());
    }

    /**
     * 根据搜索关键词查询商品信息
     *
     * @param keyword
     * @param pageable
     * @return
     */
    public Page<SolrItem> getSolrItemByKeyword(String keyword, Pageable pageable) {
        return solrItemRepository.findByNameOrShopCategoryOrShopInfoOrCategory(keyword, pageable);
    }
}
