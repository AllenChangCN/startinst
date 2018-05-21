package com.startinst.utils;

import com.startinst.model.HttpResponse;
import com.startinst.enums.HttpResponseCodeEnum;

/**
 * @author liuyuancheng
 */
public class HttpResponseUtil {

    public static HttpResponse success(Object object) {
        HttpResponse result = new HttpResponse();
        result.setCode(HttpResponseCodeEnum.SUCCESS.getCode());
        result.setMessage(HttpResponseCodeEnum.SUCCESS);
        result.setData(object);
        return result;
    }

    public static HttpResponse success() {
        return success(null);
    }

    public static HttpResponse error(HttpResponseCodeEnum msg) {
        HttpResponse result = new HttpResponse();
        result.setCode(msg.getCode());
        result.setMessage(msg);
        return result;
    }
}
