package com.itk.promotion.mapper;

import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.model.SaleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleInfoMapper {
    int countByExample(SaleInfoExample example);

    int deleteByExample(SaleInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleInfo record);

    int insertSelective(SaleInfo record);

    List<SaleInfo> selectByExample(SaleInfoExample example);

    SaleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleInfo record, @Param("example") SaleInfoExample example);

    int updateByExample(@Param("record") SaleInfo record, @Param("example") SaleInfoExample example);

    int updateByPrimaryKeySelective(SaleInfo record);

    int updateByPrimaryKey(SaleInfo record);

    List<SaleInfo> selectByShopId(String shopId);
}