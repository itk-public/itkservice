package com.itk.user.model;

/**
 * Created by zhouhui on 2017/2/14.
 */
public class UserInfoConvert {

    public static UserInfoVO convert(UserInfo userInfo, String accessToken){
        UserInfoVO vo = null;
        if(userInfo != null){
            vo = new UserInfoVO();
            vo.setUid(userInfo.getUserId());
            vo.setAccess_token(accessToken);
        }
        return vo;
    }
}
