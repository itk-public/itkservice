package com.itk.cms.mapper;

import com.itk.cms.model.TownshipInfo;
import com.itk.cms.model.TownshipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TownshipInfoMapper {
    int countByExample(TownshipInfoExample example);

    int deleteByExample(TownshipInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TownshipInfo record);

    int insertSelective(TownshipInfo record);

    List<TownshipInfo> selectByExample(TownshipInfoExample example);

    TownshipInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TownshipInfo record, @Param("example") TownshipInfoExample example);

    int updateByExample(@Param("record") TownshipInfo record, @Param("example") TownshipInfoExample example);

    int updateByPrimaryKeySelective(TownshipInfo record);

    int updateByPrimaryKey(TownshipInfo record);
}