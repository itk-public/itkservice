package com.itk.base.mapper;

import com.itk.base.model.PositionCounty;
import com.itk.base.model.PositionCountyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionCountyMapper {
    int countByExample(PositionCountyExample example);

    int deleteByExample(PositionCountyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionCounty record);

    int insertSelective(PositionCounty record);

    List<PositionCounty> selectByExample(PositionCountyExample example);

    PositionCounty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionCounty record, @Param("example") PositionCountyExample example);

    int updateByExample(@Param("record") PositionCounty record, @Param("example") PositionCountyExample example);

    int updateByPrimaryKeySelective(PositionCounty record);

    int updateByPrimaryKey(PositionCounty record);

    List<PositionCounty> selectByCityId(Long cityId);

    PositionCounty selectByCountyId(Long countyId);
}