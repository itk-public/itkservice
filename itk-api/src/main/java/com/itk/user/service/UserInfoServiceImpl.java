package com.itk.user.service;

import com.itk.user.model.UserInfo;
import com.itk.user.model.UserInfoConvert;
import com.itk.user.model.UserInfoVO;
import com.itk.utils.Constant;
import com.itk.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.UUID;

/**
 * Created by zhouhui on 2017/2/14.
 */
@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    public UserInfoVO registerUser(UserInfo record, String securityCode) throws Exception {
        try {
            byte[] code = redisTemplate.getConnectionFactory().getConnection().get(record.getPhone().getBytes());
            if(code.length>0){
                String tempCode = (String) SerializationUtils.deserialize(code);
                if(!tempCode.equals(securityCode)){
                    throw  new Exception("验证码输入有误,请重新输入！");
                }
            }
            UserInfo userInfo = userInfoService.register(record);
            String accessToken =MD5Util.stringToMD5(UUID.randomUUID().toString());
            redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
            return  UserInfoConvert.convert(userInfo,accessToken);
        } catch (Exception e) {
            throw e;
        }
    }

    public UserInfoVO forgetPwd(String phone, String securityCode, String password) throws Exception {
        byte[] code = redisTemplate.getConnectionFactory().getConnection().get(phone.getBytes());
        if(code.length>0){
            String tempCode = (String) SerializationUtils.deserialize(code);
            if(!tempCode.equals(securityCode)){
                throw  new Exception("验证码输入有误,请重新输入！");
            }
        }
        UserInfo userInfo = userInfoService.forgetPwd(phone,  password);
        String accessToken =MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(),Constant.REDIS_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
        return  UserInfoConvert.convert(userInfo,accessToken);
    }


    public UserInfoVO accountLogin(String phone, String password){
        UserInfo userInfo = userInfoService.accountLogin(phone,password);
        String accessToken =MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
        return  UserInfoConvert.convert(userInfo,accessToken);
    }



    public String getSecurityCode(String phone) throws Exception {
        String code = userInfoService.getSecurityCode(phone);
        redisTemplate.getConnectionFactory().getConnection().set(phone.getBytes(), SerializationUtils.serialize(code));
        return code;
    }

    public UserInfoVO phoneLogin(String phone, String securityCode) throws Exception {
        byte[] code = redisTemplate.getConnectionFactory().getConnection().get(phone.getBytes());
        if(code.length>0){
            String tempCode = (String) SerializationUtils.deserialize(code);
            if(!tempCode.equals(securityCode)){
                throw  new Exception("验证码输入有误,请重新输入！");
            }
        }
        UserInfo userInfo = userInfoService.phoneLogin(phone);
        String accessToken =MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().set(accessToken.getBytes(), SerializationUtils.serialize(userInfo));
        return  UserInfoConvert.convert(userInfo,accessToken);
    }

    public int updateUserInfo(UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }
}
