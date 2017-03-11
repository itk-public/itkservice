package com.itk.item.service;


import com.itk.item.model.DisplayCategory;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public interface DisplayCategoryService {

    int addDisplayCategory(DisplayCategory displayCategory);

    int updateDisplayCategory(DisplayCategory displayCategory);

    int delDisplayCategory(Integer id);

    DisplayCategory selectByPrimaryKey(Integer id);

    List<DisplayCategory> selectDisplayCategories();

    List<DisplayCategory> selectByParentId(Long parentId);
}