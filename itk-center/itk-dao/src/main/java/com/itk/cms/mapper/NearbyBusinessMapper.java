package com.itk.cms.mapper;

import com.itk.cms.model.NearbyBusiness;
import com.itk.cms.model.NearbyBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NearbyBusinessMapper {
    int countByExample(NearbyBusinessExample example);

    int deleteByExample(NearbyBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NearbyBusiness record);

    int insertSelective(NearbyBusiness record);

    List<NearbyBusiness> selectByExample(NearbyBusinessExample example);

    NearbyBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NearbyBusiness record, @Param("example") NearbyBusinessExample example);

    int updateByExample(@Param("record") NearbyBusiness record, @Param("example") NearbyBusinessExample example);

    int updateByPrimaryKeySelective(NearbyBusiness record);

    int updateByPrimaryKey(NearbyBusiness record);
}