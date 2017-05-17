package com.itk.exception;


/**
 * Created by enchen on 5/14/17.
 */
public class SystemException extends RuntimeException {

    private int code;

    public SystemException() {

    }

    public SystemException(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
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

    private String errorMessage;


    @Override
    public String toString() {
        return "SystemException{" +
                "code=" + code +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
