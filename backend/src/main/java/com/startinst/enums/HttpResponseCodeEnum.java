package com.startinst.enums;

/**
 * @author liuyuancheng
 */
public enum  HttpResponseCodeEnum {

    SUCCESS(0),
    ERR_UNKNOWN(-1)
    ;

    private Integer code;

    HttpResponseCodeEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
