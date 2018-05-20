package com.startinst.enums;

/**
 * @author liuyuancheng
 */
public enum  HttpResponseCodeEnum {

    // 成功
    SUCCESS(0),
    // 未知错误
    ERR_UNKNOWN(-1),
    // 密码不能为空
    ERR_PASSWORD_CANNOT_BE_EMPTY(-2),
    // 用户名不能为空
    ERR_USERNAME_CANNOT_BE_EMPTY(-3)
    ;

    private Integer code;

    HttpResponseCodeEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
