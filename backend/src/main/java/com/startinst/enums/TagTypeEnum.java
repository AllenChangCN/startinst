package com.startinst.enums;

/**
 * @author liuyuancheng
 */
public enum TagTypeEnum {
    // page的tag
    PAGE_TAG(0),
    ;

    private Integer code;

    TagTypeEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
