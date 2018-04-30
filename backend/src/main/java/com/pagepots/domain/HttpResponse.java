package com.pagepots.domain;

/**
 * Http 返回对象
 * @param <T>
 * @author liuyuancheng
 */
public class HttpResponse<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    private Integer status = 200;



    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
