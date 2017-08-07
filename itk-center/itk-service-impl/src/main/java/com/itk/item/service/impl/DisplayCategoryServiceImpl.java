package com.itk.item.service.impl;

import com.itk.item.convert.DisplayCategoryMapper;
import com.itk.item.model.DisplayCategory;
import com.itk.item.service.DisplayCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public class DisplayCategoryServiceImpl implements DisplayCategoryService {

    @Autowired
    private DisplayCategoryMapper displayCategoryMapper;

    @Override
    public int addDisplayCategory(DisplayCategory displayCategory) {
        return displayCategoryMapper.insertSelective(displayCategory);
    }

    @Override
    public int updateDisplayCategory(DisplayCategory displayCategory) {
        return displayCategoryMapper.updateByPrimaryKeySelective(displayCategory);
    }

    @Override
    public int delDisplayCategory(Long displayCategoryId) {
        DisplayCategory displayCategory = displayCategoryMapper.selectByPrimaryKey(displayCategoryId);
        displayCategory.setIsshow(0);
        return displayCategoryMapper.updateByPrimaryKeySelective(displayCategory);
    }

    @Override
    public DisplayCategory selectByPrimaryKey(Long displayCategoryId) {
        return displayCategoryMapper.selectByPrimaryKey(displayCategoryId);
    }

    @Override
    public List<DisplayCategory> selectDisplayCategories() {
        return displayCategoryMapper.selectDisplayCategories();
    }

    @Override
    public List<DisplayCategory> selectByParentId(Long parentId) {
        return displayCategoryMapper.selectByParentId(parentId);
    }
}
