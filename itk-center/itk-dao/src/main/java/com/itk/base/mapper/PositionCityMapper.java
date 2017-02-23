package com.itk.base.mapper;

import com.itk.base.model.PositionCity;
import com.itk.base.model.PositionCityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionCityMapper {
    int countByExample(PositionCityExample example);

    int deleteByExample(PositionCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionCity record);

    int insertSelective(PositionCity record);

    List<PositionCity> selectByExample(PositionCityExample example);

    PositionCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionCity record, @Param("example") PositionCityExample example);

    int updateByExample(@Param("record") PositionCity record, @Param("example") PositionCityExample example);

    int updateByPrimaryKeySelective(PositionCity record);

    int updateByPrimaryKey(PositionCity record);

    List<PositionCity> selectByProvinceId(Long provinceId);

    PositionCity selectByCityId(Long cityId);
}