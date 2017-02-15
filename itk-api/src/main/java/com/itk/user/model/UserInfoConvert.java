package com.itk.user.model;

/**
 * Created by zhouhui on 2017/2/14.
 */
public class UserInfoConvert {

    public static UserInfoVo convert(UserInfo userInfo, String accessToken){
        UserInfoVo vo = null;
        if(userInfo != null){
            vo = new UserInfoVo();
            vo.setUid(userInfo.getUserId());
            vo.setAccess_token(accessToken);
        }
        return vo;
    }
}
