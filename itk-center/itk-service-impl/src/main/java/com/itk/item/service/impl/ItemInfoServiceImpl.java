package com.itk.item.service.impl;

import com.itk.item.mapper.ItemCommentMapper;
import com.itk.item.mapper.ItemInfoMapper;
import com.itk.item.model.ItemComment;
import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemCommentService;
import com.itk.item.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public class ItemInfoServiceImpl implements ItemInfoService {

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Override
    public int addItemInfo(ItemInfo itemInfo) {
        return itemInfoMapper.insertSelective(itemInfo);
    }

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
        if(now.get(Calendar.DAY_OF_MONTH) == 15 || now.get(Calendar.DATE) == now.getActualMaximum(Calendar.DAY_OF_MONTH)){
            info.setPrice(itemInfo.getPrice());
        }
        info.setIsDel(itemInfo.getIsDel());
        info.setShopCategoryId(itemInfo.getShopCategoryId());
        info.setTotalStock(itemInfo.getTotalStock());
        info.setCurrentStock(itemInfo.getCurrentStock());
        info.setShopId(itemInfo.getShopId());
        info.setCategoryId(itemInfo.getCategoryId());
        info.setStatus(itemInfo.getStatus());
        return itemInfoMapper.updateByPrimaryKey(info);
    }

    @Override
    public int delItemInfo(Integer id) {
        ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(id);
        itemInfo.setIsDel(1);// 0:正常 1:删除
        return itemInfoMapper.updateByPrimaryKey(itemInfo);
    }

    @Override
    public ItemInfo selectByPrimaryKey(Integer id) {
        return itemInfoMapper.selectByPrimaryKey(id);
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
        return itemInfoMapper.selectByShopCategoryIdAndStatus(shopCategoryId,status);
    }

}
