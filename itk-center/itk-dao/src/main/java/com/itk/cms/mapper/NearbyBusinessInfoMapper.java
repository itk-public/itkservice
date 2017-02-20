package com.itk.cms.mapper;

import com.itk.cms.model.NearbyBusinessInfo;
import com.itk.cms.model.NearbyBusinessInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NearbyBusinessInfoMapper {
    int countByExample(NearbyBusinessInfoExample example);

    int deleteByExample(NearbyBusinessInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NearbyBusinessInfo record);

    int insertSelective(NearbyBusinessInfo record);

    List<NearbyBusinessInfo> selectByExample(NearbyBusinessInfoExample example);

    NearbyBusinessInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NearbyBusinessInfo record, @Param("example") NearbyBusinessInfoExample example);

    int updateByExample(@Param("record") NearbyBusinessInfo record, @Param("example") NearbyBusinessInfoExample example);

    int updateByPrimaryKeySelective(NearbyBusinessInfo record);

    int updateByPrimaryKey(NearbyBusinessInfo record);
}