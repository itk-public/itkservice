package com.itk.item.service;


import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ShopCategory;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public interface ShopCategoryService {

    int addShopCategory(ShopCategory shopCategory);

    int updateShopCategory(ShopCategory shopCategory);

    int delShopCategory(Integer id);

    ShopCategory selectByPrimaryKey(Integer id);

    List<ShopCategory> selectShopCategories();
}
