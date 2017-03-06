package com.itk.back.service;

import com.itk.back.model.BackUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/3/5.
 */
@Service
public class BackUserFrontServiceImpl {

    @Autowired
    private BackUserService backUserService;

    public int addBackUser(BackUser backUser) throws Exception{
       return backUserService.addBackUser(backUser);
    }

    public BackUser selectByPrimaryKey(Integer id){
        return backUserService.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BackUser record){
        return backUserService.updateByPrimaryKeySelective(record);
    }

    public List<BackUser> selectAllUsers(){
        return backUserService.selectAllUsers();
    }

}
