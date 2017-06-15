package com.itk.utils;

import com.itk.config.ResultCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhouhui on 2017/2/14.
 */
public class WebResult implements Serializable {

    private int code;

    private String message;

    private int exceptionEnumCode;

    private Object data;

    private Date now;

    public WebResult() {
        super();
    }

    public WebResult(int code, String message, Object data, int exceptionEnumCode) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
        this.exceptionEnumCode = exceptionEnumCode;
        this.now = new Date();
    }

    public static WebResult ok(Object data) {
        return new WebResult(ResultCode.SUCCESS, "SUCCESS", data, 0);
    }

    public static WebResult ok(String message, Object data, Integer exceptionEnumCode) {
        return new WebResult(ResultCode.SUCCESS, message, data, exceptionEnumCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    public <T> T data() {
        return (T) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getExceptionEnumCode() {
        return exceptionEnumCode;
    }

    public void setExceptionEnumCode(int exceptionEnumCode) {
        this.exceptionEnumCode = exceptionEnumCode;
    }
}
