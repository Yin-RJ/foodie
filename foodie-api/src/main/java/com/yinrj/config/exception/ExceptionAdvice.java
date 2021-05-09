package com.yinrj.config.exception;

import com.yinrj.utils.IMOOCJSONResult;
import com.yinrj.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
@RestControllerAdvice
public class ExceptionAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public IMOOCJSONResult validateExceptionHandle(Exception e) {
        LOG.error(e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            String exceptionMsg = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
            return IMOOCJSONResult.errorException(exceptionMsg);
        }
        return IMOOCJSONResult.errorException("内部异常");
    }
}
