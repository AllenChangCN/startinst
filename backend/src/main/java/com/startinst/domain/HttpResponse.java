package com.startinst.domain;

import com.startinst.enums.HttpResponseCodeEnum;

/**
 * Http 返回对象
 * @param <T>
 * @author liuyuancheng
 */
public class HttpResponse<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private HttpResponseCodeEnum message;


    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpResponseCodeEnum getMessage() {
        return message;
    }

    public void setMessage(HttpResponseCodeEnum message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
