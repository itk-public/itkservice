package com.itk.back.mapper;

import com.itk.back.model.BackUser;
import com.itk.back.model.BackUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackUserMapper {
    int countByExample(BackUserExample example);

    int deleteByExample(BackUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BackUser record);

    int insertSelective(BackUser record);

    List<BackUser> selectByExample(BackUserExample example);

    BackUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BackUser record, @Param("example") BackUserExample example);

    int updateByExample(@Param("record") BackUser record, @Param("example") BackUserExample example);

    int updateByPrimaryKeySelective(BackUser record);

    int updateByPrimaryKey(BackUser record);

    List<BackUser> selectAllUsers();

    BackUser loginBackUser(BackUser backUser);
}