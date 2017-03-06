package com.itk.cms.mapper;

import com.itk.cms.model.Hbanner;
import com.itk.cms.model.HbannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HbannerMapper {
    int countByExample(HbannerExample example);

    int deleteByExample(HbannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Hbanner record);

    int insertSelective(Hbanner record);

    List<Hbanner> selectByExample(HbannerExample example);

    Hbanner selectByPrimaryKey(Long id);

    List<Hbanner> selectHbannersByPageSortId(Integer pageSortId);

    int updateByExampleSelective(@Param("record") Hbanner record, @Param("example") HbannerExample example);

    int updateByExample(@Param("record") Hbanner record, @Param("example") HbannerExample example);

    int updateByPrimaryKeySelective(Hbanner record);

    int updateByPrimaryKey(Hbanner record);
}