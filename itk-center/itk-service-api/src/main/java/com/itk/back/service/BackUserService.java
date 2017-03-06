package com.itk.back.service;

import com.itk.back.model.BackUser;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/12.
 */
public interface BackUserService {

    int addBackUser(BackUser backUser) throws Exception;

    BackUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackUser record);

    List<BackUser> selectAllUsers();

    BackUser loginBackUser(BackUser backUser);
}
