package com.itk.item.service.impl;

import com.itk.item.mapper.DisplayCategoryMapper;
import com.itk.item.mapper.ShopCategoryMapper;
import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ShopCategory;
import com.itk.item.service.DisplayCategoryService;
import com.itk.item.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public int addShopCategory(ShopCategory shopCategory) {
        return shopCategoryMapper.insertSelective(shopCategory);
    }

    @Override
    public int updateShopCategory(ShopCategory shopCategory) {
        return shopCategoryMapper.updateByPrimaryKeySelective(shopCategory);
    }

    @Override
    public int delShopCategory(Integer id) {
        ShopCategory shopCategory = shopCategoryMapper.selectByPrimaryKey(id);
        shopCategory.setIsshow(0);
        return shopCategoryMapper.updateByPrimaryKeySelective(shopCategory);
    }

    @Override
    public ShopCategory selectByPrimaryKey(Integer id) {
        return shopCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopCategory> selectShopCategories() {
        return shopCategoryMapper.selectShopCategories();
    }
}
