package com.itk.cms.mapper;

import com.itk.cms.model.HomePage;
import com.itk.cms.model.HomePageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomePageMapper {
    int countByExample(HomePageExample example);

    int deleteByExample(HomePageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomePage record);

    int insertSelective(HomePage record);

    List<HomePage> selectByExample(HomePageExample example);

    HomePage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomePage record, @Param("example") HomePageExample example);

    int updateByExample(@Param("record") HomePage record, @Param("example") HomePageExample example);

    int updateByPrimaryKeySelective(HomePage record);

    int updateByPrimaryKey(HomePage record);

    List<HomePage> selectHomePages();
}