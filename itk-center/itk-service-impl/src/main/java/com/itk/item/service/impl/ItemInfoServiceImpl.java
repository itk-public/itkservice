package com.itk.item.service.impl;

import com.itk.item.convert.ItemInfoMapper;
import com.itk.item.model.ItemInfo;
import com.itk.item.model.ItemInfoExample;
import com.itk.item.service.ItemInfoService;
import com.itk.solr.model.SolrItem;
import com.itk.solr.service.SolrItemService;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;


/**
 * Created by enchen on 2/21/17.
 */
public class ItemInfoServiceImpl implements ItemInfoService {

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private SolrItemService solrItemService;

    @Transactional
    @Override
    public int addItemInfo(ItemInfo itemInfo) {
        itemInfo.setItemId(UUID.randomUUID().toString());
        int i = itemInfoMapper.insertSelective(itemInfo);
        //添加搜索引擎数据
        solrItemService.saveItemInfo(itemInfo);
        return i;
    }

    @Transactional
    @Override
    public int updateItemInfo(ItemInfo itemInfo) {
        Calendar now = Calendar.getInstance();

        ItemInfo info = itemInfoMapper.selectByPrimaryKey(itemInfo.getId());
        info.setName(itemInfo.getName());
        info.setMainsrc(itemInfo.getMainsrc());
        info.setBarCode(itemInfo.getBarCode());
        info.setItemId(itemInfo.getItemId());
        info.setDetailsrc(itemInfo.getDetailsrc());
        //当前日期是15号或者月末
        if (now.get(Calendar.DAY_OF_MONTH) == 15 || now.get(Calendar.DATE) == now.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            info.setPrice(itemInfo.getPrice());
        }
        info.setIsDel(itemInfo.getIsDel());
        info.setShopCategoryId(itemInfo.getShopCategoryId());
        info.setTotalStock(itemInfo.getTotalStock());
        info.setCurrentStock(itemInfo.getCurrentStock());
        info.setShopId(itemInfo.getShopId());
        info.setCategoryId(itemInfo.getCategoryId());
        info.setStatus(itemInfo.getStatus());
        int i = itemInfoMapper.updateByPrimaryKey(info);
        ItemInfo updateInfo = itemInfoMapper.selectByPrimaryKey(info.getId());
        //更新后数据添加到搜索引擎
        solrItemService.saveItemInfo(updateInfo);
        return i;
    }

    @Transactional
    @Override
    public int delItemInfo(Integer id) {
        ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(id);
        itemInfo.setIsDel(1);// 0:正常 1:删除
        int i = itemInfoMapper.updateByPrimaryKey(itemInfo);
        //删除商品索引
        solrItemService.deleteItemInfo(itemInfo);
        return i;
    }

    @Override
    public ItemInfo selectByPrimaryKey(Integer id) {
        return itemInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public ItemInfo selectByItemId(String itemId) {
        ItemInfoExample example = new ItemInfoExample();
        example
                .or()
                .andItemIdEqualTo(itemId);
        List<ItemInfo> itemInfoList = itemInfoMapper.selectByExample(example);
        return itemInfoList.size() > 0 ? itemInfoList.get(0) : null;
    }

    @Override
    public List<ItemInfo> selectByCategoryIdAndStatus(Long categoryId, Integer status) {
        return itemInfoMapper.selectByCategoryIdAndStatus(categoryId, status);
    }

    @Override
    public List<ItemInfo> selectByShopIdAndStatus(Long shopId, Integer status) {
        return itemInfoMapper.selectByShopIdAndStatus(shopId, status);
    }

    @Override
    public List<ItemInfo> selectByShopCategoryIdAndStatus(Integer shopCategoryId, Integer status) {
        return itemInfoMapper.selectByShopCategoryIdAndStatus(shopCategoryId, status);
    }

    @Override
    public PageInfo<SolrItem> selectSolrItemByKeyword(String keyword, PageParam pageParam) {
        Pageable pageable = new PageRequest(pageParam.getPageNum() <= 0 ? 0 : pageParam.getPageNum() - 1, pageParam.getPageSize());
        Page<SolrItem> page = solrItemService.getSolrItemByKeyword(keyword, pageable);
        return new PageInfo<>(page);
    }

}
