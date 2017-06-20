package com.itk.item.service;


import com.itk.item.model.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class ItemInfoFrontServiceImpl {

    @Autowired
    private ItemInfoService itemInfoService;

    public int addItemInfo(ItemInfo itemInfo){
        return itemInfoService.addItemInfo(itemInfo);
    }

    public int updateItemInfo(ItemInfo itemInfo){
        return itemInfoService.updateItemInfo(itemInfo);
    }

    public int delItemInfo(Integer itemInfoId){
        return itemInfoService.delItemInfo(itemInfoId);
    }

    public ItemInfo selectByPrimaryKey(Integer itemCommentId){
        return itemInfoService.selectByPrimaryKey(itemCommentId);
    }

    public List<ItemInfo> selectByCategoryIdAndStatus(Long categoryId, Integer status){
        return itemInfoService.selectByCategoryIdAndStatus(categoryId, status);
    }

    public List<ItemInfo> selectByShopIdAndStatus(Long shopId, Integer status){
        return itemInfoService.selectByShopIdAndStatus(shopId, status);
    }

    public List<ItemInfo> selectByShopCategoryIdAndStatus(Integer shopCategoryId, Integer status) {
        return itemInfoService.selectByShopCategoryIdAndStatus(shopCategoryId, status);
    }
}
