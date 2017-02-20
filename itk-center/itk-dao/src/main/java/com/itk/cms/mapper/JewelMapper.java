package com.itk.cms.mapper;

import com.itk.cms.model.Jewel;
import com.itk.cms.model.JewelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JewelMapper {
    int countByExample(JewelExample example);

    int deleteByExample(JewelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Jewel record);

    int insertSelective(Jewel record);

    List<Jewel> selectByExample(JewelExample example);

    Jewel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Jewel record, @Param("example") JewelExample example);

    int updateByExample(@Param("record") Jewel record, @Param("example") JewelExample example);

    int updateByPrimaryKeySelective(Jewel record);

    int updateByPrimaryKey(Jewel record);
}