package com.itk.cms.mapper;

import com.itk.cms.model.Skupos;
import com.itk.cms.model.SkuposExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuposMapper {
    int countByExample(SkuposExample example);

    int deleteByExample(SkuposExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Skupos record);

    int insertSelective(Skupos record);

    List<Skupos> selectByExample(SkuposExample example);

    Skupos selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Skupos record, @Param("example") SkuposExample example);

    int updateByExample(@Param("record") Skupos record, @Param("example") SkuposExample example);

    int updateByPrimaryKeySelective(Skupos record);

    int updateByPrimaryKey(Skupos record);
}