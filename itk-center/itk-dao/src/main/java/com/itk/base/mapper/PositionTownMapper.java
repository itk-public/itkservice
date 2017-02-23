package com.itk.base.mapper;

import com.itk.base.model.PositionTown;
import com.itk.base.model.PositionTownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionTownMapper {
    int countByExample(PositionTownExample example);

    int deleteByExample(PositionTownExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionTown record);

    int insertSelective(PositionTown record);

    List<PositionTown> selectByExample(PositionTownExample example);

    PositionTown selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionTown record, @Param("example") PositionTownExample example);

    int updateByExample(@Param("record") PositionTown record, @Param("example") PositionTownExample example);

    int updateByPrimaryKeySelective(PositionTown record);

    int updateByPrimaryKey(PositionTown record);
}