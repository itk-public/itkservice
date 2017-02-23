package com.itk.base.mapper;

import com.itk.base.model.PositionVillage;
import com.itk.base.model.PositionVillageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionVillageMapper {
    int countByExample(PositionVillageExample example);

    int deleteByExample(PositionVillageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionVillage record);

    int insertSelective(PositionVillage record);

    List<PositionVillage> selectByExample(PositionVillageExample example);

    PositionVillage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionVillage record, @Param("example") PositionVillageExample example);

    int updateByExample(@Param("record") PositionVillage record, @Param("example") PositionVillageExample example);

    int updateByPrimaryKeySelective(PositionVillage record);

    int updateByPrimaryKey(PositionVillage record);
}