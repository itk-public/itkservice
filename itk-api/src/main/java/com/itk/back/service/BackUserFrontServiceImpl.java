package com.itk.back.service;

import com.itk.back.model.BackUser;
import com.itk.utils.Constant;
import com.itk.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhouhui on 2017/3/5.
 */
@Service
public class BackUserFrontServiceImpl {

    @Autowired
    private BackUserService backUserService;

    @Autowired
    private RedisTemplate redisTemplate;

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

    public Map<String,String> loginBackUser(BackUser backUser) {
        BackUser retUser = backUserService.loginBackUser(backUser);
        if(retUser != null){
            Map<String, String> retMap = new HashMap<String, String>();
            String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
            redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(retUser));
            retMap.put("access_token", accessToken);
            return retMap;
        }
       return null;
    }
}
