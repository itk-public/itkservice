package com.itk.back.service;

import com.itk.back.model.BackUser;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/12.
 */
public interface BackUserService {

    int addBackUser(BackUser backUser);

    BackUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackUser record);

    List<BackUser> selectAllUsers();

    BackUser loginBackUser(BackUser backUser);

    List<BackUser> selectByUsername(String username);

    List<BackUser> selectByPhone(String phone);

    List<BackUser> selectByEmail(String email);
}
