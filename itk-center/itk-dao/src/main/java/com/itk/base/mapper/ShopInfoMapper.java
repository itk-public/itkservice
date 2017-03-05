package com.itk.base.mapper;

import com.itk.base.model.ShopInfo;
import com.itk.base.model.ShopInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopInfoMapper {
    int countByExample(ShopInfoExample example);

    int deleteByExample(ShopInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    List<ShopInfo> selectByExample(ShopInfoExample example);

    ShopInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByExample(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);

    List<ShopInfo> selectByTownshipId(Long townshipId);

    List<ShopInfo> selectShopInfos();
}