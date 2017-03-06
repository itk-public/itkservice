package com.itk.back.service.impl;

import com.itk.back.mapper.BackUserMapper;
import com.itk.back.model.BackUser;
import com.itk.back.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/3/5.
 */
public class BackUserServiceImpl implements BackUserService {

    @Autowired
    private BackUserMapper backUserMapper;

    @Override
    public int addBackUser(BackUser backUser) throws Exception {
        return backUserMapper.insertSelective(backUser);
    }

    @Override
    public BackUser selectByPrimaryKey(Integer id) {
        return backUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BackUser record) {
        return backUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<BackUser> selectAllUsers() {
        return backUserMapper.selectAllUsers();
    }

    @Override
    public BackUser loginBackUser(BackUser backUser) {
        return backUserMapper.loginBackUser(backUser);
    }
}
