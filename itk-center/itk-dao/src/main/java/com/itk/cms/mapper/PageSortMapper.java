package com.itk.cms.mapper;

import com.itk.cms.model.PageSort;
import com.itk.cms.model.PageSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageSortMapper {
    int countByExample(PageSortExample example);

    int deleteByExample(PageSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageSort record);

    int insertSelective(PageSort record);

    List<PageSort> selectByExample(PageSortExample example);

    PageSort selectByPrimaryKey(Long id);

    List<PageSort> selectPageSortsByHomePageId(Long homePageId);

    int updateByExampleSelective(@Param("record") PageSort record, @Param("example") PageSortExample example);

    int updateByExample(@Param("record") PageSort record, @Param("example") PageSortExample example);

    int updateByPrimaryKeySelective(PageSort record);

    int updateByPrimaryKey(PageSort record);
}