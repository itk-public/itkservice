package com.itk.utils;

import java.math.BigDecimal;

/**
 *
 * 常量
 * Created by zhouhui on 2017/2/14.
 */
public class Constant {

    public static final String EmptyString = "";
    public static final String SYSTEM_USER = "system";
    /**
     * Default decimal scale
     */
    public static final int DEFAULT_SCALE = 2;
    public static final BigDecimal ZERODECIMAL = new BigDecimal("0.00").setScale(Constant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);
    public static final BigDecimal ONEDECIMAL = new BigDecimal("1.00").setScale(Constant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);
    public static final BigDecimal HUNDREDDECIMAL = new BigDecimal("100.00").setScale(Constant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);
    /**
     * Default decimal ROUND
     */
    public static final int DEFAULT_ROUND = BigDecimal.ROUND_HALF_UP;

    /**
     * Predefined Http Code
     */
    public static final int HTTPCODE_OK = HttpStatus.OK.value();
    public static final int HTTPCODE_INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final int HTTPCODE_USER_ERROR = HttpStatus.BAD_REQUEST.value();

    /**
     * Predefined Error Code
     */
    //System error code 0 ~ 10000
    public static final int ERRORCODE_OK = 0;
    public static final int ERRORCODE_INTERNAL_SERVER_ERROR = 500;
    public static final String ERRORMESSAGE_INTERNAL_ERROR = "服务器内部错误，请稍后重试。";
    public static final int ERRORCODE_SERVER_BUSY = 501;
    public static final String ERRORMESSAGE_SERVER_BUSY = "服务器繁忙，请稍后重试。";


    /**
     * redis
     */
    public static final long REDIS_CODE_EXPIRE_TIME_BY_SECONDS = 300L;
    public static final long REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS = 259200L;

}
