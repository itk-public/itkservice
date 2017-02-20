package com.itk.cms.mapper;

import com.itk.cms.model.SeckillSeason;
import com.itk.cms.model.SeckillSeasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillSeasonMapper {
    int countByExample(SeckillSeasonExample example);

    int deleteByExample(SeckillSeasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillSeason record);

    int insertSelective(SeckillSeason record);

    List<SeckillSeason> selectByExample(SeckillSeasonExample example);

    SeckillSeason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillSeason record, @Param("example") SeckillSeasonExample example);

    int updateByExample(@Param("record") SeckillSeason record, @Param("example") SeckillSeasonExample example);

    int updateByPrimaryKeySelective(SeckillSeason record);

    int updateByPrimaryKey(SeckillSeason record);
}