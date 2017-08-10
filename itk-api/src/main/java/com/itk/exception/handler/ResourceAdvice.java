package com.itk.exception.handler;

import com.itk.exception.ObjectNotFoundException;
import com.itk.exception.SystemException;
import com.itk.util.Constant;
import com.itk.util.LocaleLanguageUtil;
import com.itk.util.ResultCode;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by enchen on 5/17/17.
 */
@ControllerAdvice
public class ResourceAdvice {

    @Autowired
    MessageSource exceptionSource;

    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public WebResult handleSystemException(SystemException e) {
        String message = e.getErrorMessage();
        if (StringUtils.isEmpty(message)) {
            message = exceptionSource.getMessage(e.getCode() + "", new String[]{}, ResultCode.UNKNOW_SOURCE, e.getLocale());
        }
        return new WebResult(e.getCode(), message, null, e.getCode());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseBody
    public WebResult handleObjectNotFoundException(ObjectNotFoundException e) {
        String message = exceptionSource.getMessage(ResultCode.NOT_FOUND + "", new String[]{}, ResultCode.UNKNOW_SOURCE, e.getLocale());
        return new WebResult(ResultCode.NOT_FOUND, message, null, ResultCode.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WebResult handleException(Exception e) {
        String errorMessage = exceptionSource.getMessage(ResultCode.SYSTEM_ERROR + "", new String[]{}, ResultCode.UNKNOW_SOURCE, LocaleLanguageUtil.DEFAULT_LOCALE);
        return new WebResult(ResultCode.SYSTEM_ERROR, errorMessage, e.getMessage(), ResultCode.SYSTEM_ERROR);
    }

}
