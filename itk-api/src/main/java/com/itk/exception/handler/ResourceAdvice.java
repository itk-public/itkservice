package com.itk.exception.handler;

import com.itk.exception.SystemException;
import com.itk.utils.WebResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by enchen on 5/17/17.
 */
@ControllerAdvice
public class ResourceAdvice {

    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public WebResult handleValidationException(SystemException e) {
        return WebResult.ok("", e.getErrorMessage(), e.getCode());
    }

}
