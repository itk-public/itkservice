package com.itk.back.service;

import com.itk.back.model.BackUser;
import com.itk.exception.SystemException;
import com.itk.util.Constant;
import com.itk.util.MD5Util;
import com.itk.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SerializationUtils;

import java.util.*;

/**
 * Created by zhouhui on 2017/3/5.
 */
@Service
public class BackUserFrontServiceImpl {

    @Autowired
    private BackUserService backUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional
    public int addBackUser(BackUser backUserReq) {
        BackUser backUser = new BackUser();
        if (backUserService.selectByUsername(backUserReq.getUsername()).size() > 0) {
            throw new SystemException(ResultCode.USERNAME_EXIST);
        }

        if (backUserService.selectByEmail(backUserReq.getEmail()).size() > 0) {
            throw new SystemException(ResultCode.EMAIL_EXIST);
        }

        if (backUserService.selectByPhone(backUserReq.getPhone()).size() > 0) {
            throw new SystemException(ResultCode.PHONE_EXIST);
        }
        backUser.setName(backUserReq.getName());
        backUser.setUsername(backUserReq.getUsername());
        backUser.setIsDel(0);
        backUser.setCreateDate(new Date());
        backUser.setPassword(MD5Util.stringToMD5(backUserReq.getPassword()));
        backUser.setPhone(backUserReq.getPhone());
        backUser.setEmail(backUserReq.getEmail());
        backUser.setLastloginDate(new Date());
        return backUserService.addBackUser(backUser);
    }

    public BackUser selectByPrimaryKey(Integer id) {
        return backUserService.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKeySelective(BackUser record) {
        record.setPassword(MD5Util.stringToMD5(record.getPassword()));
        return backUserService.updateByPrimaryKeySelective(record);
    }

    public List<BackUser> selectAllUsers() {
        return backUserService.selectAllUsers();
    }

    public Map<String, String> loginBackUser(BackUser backUser) {
        BackUser retUser = backUserService.loginBackUser(backUser);
        if (retUser != null) {
            Map<String, String> retMap = new HashMap<String, String>();
            String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
            redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(retUser));
            retMap.put("access_token", accessToken);
            return retMap;
        }
        return null;
    }

    public Boolean usernameIsExist(String username) {
        return backUserService.selectByUsername(username).size() > 0 ? true : false;
    }

    public Boolean emailIsExist(String email) {
        return backUserService.selectByEmail(email).size() > 0 ? true : false;
    }

    public Boolean phoneIsExist(String phone) {
        return backUserService.selectByPhone(phone).size() > 0 ? true : false;
    }
}
