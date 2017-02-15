package com.itk.user.model;

/**
 * Created by zhouhui on 2017/2/14.
 */
public class UserInfoVO {

    private String access_token;
    private String uid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
