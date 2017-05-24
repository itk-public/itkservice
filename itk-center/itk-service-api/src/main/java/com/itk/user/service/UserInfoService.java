package com.itk.user.service;

import com.itk.user.model.UserInfo;

/**
 * Created by zhouhui on 2017/2/12.
 */
public interface UserInfoService {

    UserInfo register(UserInfo userInfo) throws Exception;

    UserInfo forgetPwd(String phone, String password);

    UserInfo accountLogin(String phone, String password);

    String getSecurityCode(String phone);

    UserInfo phoneLogin(String phone) throws Exception;

    int updateUserInfo(UserInfo userInfo);

    UserInfo findUserByPhone(String userName);
}
