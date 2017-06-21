package com.itk.user.service;

import com.itk.user.model.UserInfo;
import com.itk.user.model.UserInfoConvert;
import com.itk.user.model.UserInfoVO;
import com.itk.util.Constant;
import com.itk.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.UUID;

/**
 * Created by zhouhui on 2017/2/14.
 */
@Service
public class UserInfoFrontServiceImpl {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    public UserInfoVO registerUser(UserInfo record, String securityCode) throws Exception {
        byte[] code = redisTemplate.getConnectionFactory().getConnection().get(record.getPhone().getBytes());
        checkCode(code, securityCode);
        try {
            UserInfo userInfo = userInfoService.register(record);
            String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
            redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
            return UserInfoConvert.convert(userInfo, accessToken);
        } catch (Exception e) {
            throw e;
        }
    }

    public UserInfoVO forgetPwd(String phone, String securityCode, String password) throws Exception {
        byte[] code = redisTemplate.getConnectionFactory().getConnection().get(phone.getBytes());
        checkCode(code, securityCode);
        UserInfo userInfo = userInfoService.forgetPwd(phone, MD5Util.stringToMD5(password));
        String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
        return UserInfoConvert.convert(userInfo, accessToken);
    }


    public UserInfoVO accountLogin(String phone, String password) {
        UserInfo userInfo = userInfoService.accountLogin(phone, MD5Util.stringToMD5(password));
        String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().setEx(accessToken.getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(userInfo));
        return UserInfoConvert.convert(userInfo, accessToken);
    }


    public String getSecurityCode(String phone) throws Exception {
        String code = userInfoService.getSecurityCode(phone);
        redisTemplate.getConnectionFactory().getConnection().setEx(phone.getBytes(), Constant.REDIS_CODE_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(code));
        return code;
    }

    public UserInfoVO phoneLogin(String phone, String securityCode) throws Exception {
        byte[] code = redisTemplate.getConnectionFactory().getConnection().get(phone.getBytes());
        checkCode(code, securityCode);
        UserInfo userInfo = userInfoService.phoneLogin(phone);
        String accessToken = MD5Util.stringToMD5(UUID.randomUUID().toString());
        redisTemplate.getConnectionFactory().getConnection().set(accessToken.getBytes(), SerializationUtils.serialize(userInfo));
        return UserInfoConvert.convert(userInfo, accessToken);
    }

    public int updateUserInfo(UserInfo record, String accessToken) throws Exception {
        byte[] userInfo = redisTemplate.getConnectionFactory().getConnection().get(accessToken.getBytes());
        if (userInfo == null) {
            throw new Exception("修改密码失败，请登陆！");
        }
        UserInfo tempUser = (UserInfo) SerializationUtils.deserialize(userInfo);
        record.setPhone(tempUser.getPhone());
        return userInfoService.updateUserInfo(record);
    }

    private static void checkCode(byte[] code, String securityCode) throws Exception {
        Converter<byte[], Object> deserializer = new DeserializingConverter();
        if (code != null) {
            String tempCode = (String) SerializationUtils.deserialize(code);
            if (!tempCode.equals(securityCode)) {
                throw new Exception("验证码输入有误,请重新输入！");
            }
        }else{
            throw new Exception("验证码有误！");
        }
    }
}
