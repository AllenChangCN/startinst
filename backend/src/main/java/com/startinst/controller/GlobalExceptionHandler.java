package com.startinst.controller;

import com.startinst.enums.HttpResponseCodeEnum;
import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

/**
 * @author liuyuancheng
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理 404错误
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public HttpResponse requestHandlingNoHandlerFound() {
        return HttpResponseUtil.error(HttpResponseCodeEnum.ERR_PAGE_NOT_FOUND);
    }

    /**
     * 处理500错误
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public HttpResponse requestHandlingInternalServerError() {
        return HttpResponseUtil.error(HttpResponseCodeEnum.ERR_INTERNAL_SERVER_ERROR);
    }
}
