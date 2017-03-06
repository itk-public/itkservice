package com.itk.base.mapper;

import com.itk.base.model.PositionProvince;
import com.itk.base.model.PositionProvinceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionProvinceMapper {
    int countByExample(PositionProvinceExample example);

    int deleteByExample(PositionProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionProvince record);

    int insertSelective(PositionProvince record);

    List<PositionProvince> selectByExample(PositionProvinceExample example);

    PositionProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionProvince record, @Param("example") PositionProvinceExample example);

    int updateByExample(@Param("record") PositionProvince record, @Param("example") PositionProvinceExample example);

    int updateByPrimaryKeySelective(PositionProvince record);

    int updateByPrimaryKey(PositionProvince record);

    List<PositionProvince> selectAllProvince();

    PositionProvince selectByProvinceId(Integer provinceId);
}