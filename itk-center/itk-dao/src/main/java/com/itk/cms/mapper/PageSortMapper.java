package com.itk.cms.mapper;

import com.itk.cms.model.PageSort;
import com.itk.cms.model.PageSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageSortMapper {
    int countByExample(PageSortExample example);

    int deleteByExample(PageSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageSort record);

    int insertSelective(PageSort record);

    List<PageSort> selectByExample(PageSortExample example);

    PageSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageSort record, @Param("example") PageSortExample example);

    int updateByExample(@Param("record") PageSort record, @Param("example") PageSortExample example);

    int updateByPrimaryKeySelective(PageSort record);

    int updateByPrimaryKey(PageSort record);
}