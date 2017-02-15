package com.itk.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kainlin on 2015/10/16.
 */
public class WebResult implements Serializable {

    private int code;

    private String message;

    private Object data;

    private Date now;

    public WebResult() {
        super();
    }

    public WebResult(int code, String message, Object data) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
        this.now = new Date();
    }

    public static WebResult ok(Object data) {
        return new WebResult(Constant.ERRORCODE_OK, "", data);
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
}
