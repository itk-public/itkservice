package com.itk.exception;


import com.itk.util.Constant;

import java.util.Locale;

/**
 * Created by enchen on 5/14/17.
 */
public class SystemException extends RuntimeException {

    private int code;

    private String errorMessage;

    private Locale locale = Constant.DEFAULT_LOCALE;

    public SystemException() {

    }

    public SystemException(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public SystemException(int code) {
        this.code = code;
    }

    public SystemException(int code, Locale locale) {
        this.code = code;
        this.locale = locale;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "SystemException{" +
                "code=" + code +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
