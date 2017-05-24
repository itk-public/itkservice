package com.itk.user.service.impl;

import com.itk.user.mapper.SecurityCodeMapper;
import com.itk.user.mapper.UserInfoMapper;
import com.itk.user.model.SecurityCode;
import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/12.
 */
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SecurityCodeMapper securityCodeMapper;


    @Override
    public UserInfo register(UserInfo userInfo) throws Exception {
        UserInfo rspUserinfo = null;
        try {
            int result = userInfoMapper.insertSelective(userInfo);
            if (result > 0) {
                rspUserinfo = userInfoMapper.selectCurrentUser(userInfo);
                securityCodeMapper.deleteByPhone(rspUserinfo.getPhone());
            }
        } catch (Exception e) {
            throw new Exception("用户已存在！");
        }

        return rspUserinfo;
    }

    @Override
    public UserInfo forgetPwd(String phone, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setLastloginDate(new Date());
        userInfoMapper.updateByPhoneSelective(userInfo);
        securityCodeMapper.deleteByPhone(phone);
        return userInfoMapper.selectCurrentUser(userInfo);

    }

    @Override
    public UserInfo accountLogin(String phone, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setLastloginDate(new Date());
        return userInfoMapper.selectCurrentUser(userInfo);
    }

    @Override
    public String getSecurityCode(String phone) {
        SecurityCode code = new SecurityCode();
        code.setPhone(phone);
        code.setCreateDate(new Date());
        code.setSecurityCode(SecurityCodeUtil.getRandomString(6));
        if (securityCodeMapper.insertSelective(code) > 0) {
            return code.getSecurityCode();
        }
        return null;
    }

    @Override
    public UserInfo phoneLogin(String phone) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        userInfo.setLastloginDate(new Date());
        securityCodeMapper.deleteByPhone(phone);
        return userInfoMapper.selectCurrentUser(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPhoneSelective(userInfo);
    }

    /**
     * 根据电话查询用户
     * @param phone
     * @return
     */
    @Override
    public UserInfo findUserByPhone(String phone) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        return userInfoMapper.selectCurrentUser(userInfo);
    }
}
