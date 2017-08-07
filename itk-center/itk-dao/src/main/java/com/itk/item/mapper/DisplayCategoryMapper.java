package com.itk.item.mapper;

import com.itk.item.model.DisplayCategoryExample;
import com.itk.item.model.DisplayCategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DisplayCategoryMapper {
    int countByExample(DisplayCategoryExample example);

    int deleteByExample(DisplayCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DisplayCategory record);

    int insertSelective(DisplayCategory record);

    List<DisplayCategory> selectByExample(DisplayCategoryExample example);

    DisplayCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DisplayCategory record, @Param("example") DisplayCategoryExample example);

    int updateByExample(@Param("record") DisplayCategory record, @Param("example") DisplayCategoryExample example);

    int updateByPrimaryKeySelective(DisplayCategory record);

    int updateByPrimaryKey(DisplayCategory record);

    List<DisplayCategory> selectDisplayCategories();

    List<DisplayCategory> selectByParentId(Long parentId);
}