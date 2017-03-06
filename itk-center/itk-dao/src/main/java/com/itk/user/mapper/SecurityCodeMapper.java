package com.itk.user.mapper;

import com.itk.user.model.SecurityCode;
import com.itk.user.model.SecurityCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecurityCodeMapper {
    int countByExample(SecurityCodeExample example);

    int deleteByExample(SecurityCodeExample example);

    int deleteByPhone(String phone);

    int insert(SecurityCode record);

    int insertSelective(SecurityCode record);

    List<SecurityCode> selectByExample(SecurityCodeExample example);

    int updateByExampleSelective(@Param("record") SecurityCode record, @Param("example") SecurityCodeExample example);

    int updateByExample(@Param("record") SecurityCode record, @Param("example") SecurityCodeExample example);

    int updateByPrimaryKeySelective(SecurityCode record);

    int updateByPrimaryKey(SecurityCode record);
}