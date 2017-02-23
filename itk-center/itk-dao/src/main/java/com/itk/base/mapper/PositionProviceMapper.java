package com.itk.base.mapper;

import com.itk.base.model.PositionProvice;
import com.itk.base.model.PositionProviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionProviceMapper {
    int countByExample(PositionProviceExample example);

    int deleteByExample(PositionProviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionProvice record);

    int insertSelective(PositionProvice record);

    List<PositionProvice> selectByExample(PositionProviceExample example);

    PositionProvice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionProvice record, @Param("example") PositionProviceExample example);

    int updateByExample(@Param("record") PositionProvice record, @Param("example") PositionProviceExample example);

    int updateByPrimaryKeySelective(PositionProvice record);

    int updateByPrimaryKey(PositionProvice record);
}