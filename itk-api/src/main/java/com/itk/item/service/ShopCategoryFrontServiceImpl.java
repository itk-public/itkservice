package com.itk.item.service;


import com.itk.item.model.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class ShopCategoryFrontServiceImpl {

    @Autowired
    private ShopCategoryService shopCategoryService;

    public int addShopCategory(ShopCategory shopCategory){
        return shopCategoryService.addShopCategory(shopCategory);
    }

    public int updateShopCategory(ShopCategory shopCategory){
        return shopCategoryService.updateShopCategory(shopCategory);
    }

    public int delShopCategory(Integer shopCategoryId){
        return shopCategoryService.delShopCategory(shopCategoryId);
    }

    public ShopCategory selectByPrimaryKey(Integer shopCategoryId){
        return shopCategoryService.selectByPrimaryKey(shopCategoryId);
    }

    public List<ShopCategory> selectShopCategories(){
        return shopCategoryService.selectShopCategories();
    }

}
