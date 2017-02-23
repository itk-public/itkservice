package com.itk.base.mapper;

import com.itk.base.model.PositionProvince;
import com.itk.base.model.PositionProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}