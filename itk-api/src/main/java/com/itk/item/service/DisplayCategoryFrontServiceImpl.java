package com.itk.item.service;


import com.itk.item.model.DisplayCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class DisplayCategoryFrontServiceImpl {

    @Autowired
    private DisplayCategoryService displayCategoryService;

    public int addDisplayCategory(DisplayCategory displayCategory){
        return displayCategoryService.addDisplayCategory(displayCategory);
    }

    public int updateDisplayCategory(DisplayCategory displayCategory){
        return displayCategoryService.updateDisplayCategory(displayCategory);
    }

    public int delDisplayCategory(Integer displayCategoryId){
        return displayCategoryService.delDisplayCategory(displayCategoryId);
    }

    public DisplayCategory selectByPrimaryKey(Integer displayCategoryId){
        return displayCategoryService.selectByPrimaryKey(displayCategoryId);
    }

    public List<DisplayCategory> selectDisplayCategories(){
        return displayCategoryService.selectDisplayCategories();
    }

    public List<DisplayCategory> selectDisplayCategoriesByParentId(Long parentId){
        return displayCategoryService.selectByParentId(parentId);
    }
}
