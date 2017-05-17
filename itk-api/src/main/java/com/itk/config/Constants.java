package com.itk.config;

/**
 * Created by enchen on 5/14/17.
 */
public final class Constants {

    /** languae */
    public static final String DEFAULT_LANGUAGE = "zh_CN";
    public static final String EN_LANGUAGE = "en";

    /** exception message id , 与 i18n 文件中 key 对应 */
    public static final String VALIDATION_1001 = "1001";    //用户名已存在
    public static final String VALIDATION_1002 = "1002";    //邮箱已存在
    public static final String VALIDATION_1003 = "1003";    //手机号已存在

    private Constants() {
    }
}
