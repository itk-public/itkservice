package com.itk.util;

/**
 * Created by young on 2017/5/24.
 */
public final class ResultCode {

    /**
     * com.itk.exception message id , 与 i18n 文件中 key 对应
     */

    public static final String UNKNOW_ERROR = "UNKNOW ERROR";

    public static final String UNKNOW_SOURCE = "UNKNOW SOURCE";

    //请求成功
    public static final int SUCCESS = 0;

    public static final int NOT_FOUND = 404;    //找不到对象

    public static final int ADD_SUCCESS = 201;  //添加成功

    public static final int EDIT_SUCCESS = 202; //修改成功

    public static final int DELETE_SUCCESS = 203;   //删除成功


    //用户相关错误
    public static final int USERNAME_EXIST = 1001;    //用户名已存在
    public static final int EMAIL_EXIST = 1002;    //邮箱已存在
    public static final int PHONE_EXIST = 1003;    //手机号已存在

    //biz attribute not null error
    public static final int PICK_SELF_LOCATION_ID = 2001;
    public static final int ORDER_ID_REQUIRED = 2002;

    //系统错误
    public static final int SYSTEM_ERROR = 5001;       //系统内部错误
}
