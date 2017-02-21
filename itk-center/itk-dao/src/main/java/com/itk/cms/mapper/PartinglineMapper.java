package com.itk.cms.mapper;

import com.itk.cms.model.Partingline;
import com.itk.cms.model.PartinglineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartinglineMapper {
    int countByExample(PartinglineExample example);

    int deleteByExample(PartinglineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Partingline record);

    int insertSelective(Partingline record);

    List<Partingline> selectByExample(PartinglineExample example);

    Partingline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Partingline record, @Param("example") PartinglineExample example);

    int updateByExample(@Param("record") Partingline record, @Param("example") PartinglineExample example);

    int updateByPrimaryKeySelective(Partingline record);

    int updateByPrimaryKey(Partingline record);

    List<Partingline> selectPartinglinesByPageSortId(Long pageSortId);
}