package com.pagepots.utils;

import com.pagepots.domain.HttpResponse;

/**
 * @author liuyuancheng
 */
public class HttpJsonResultUtil {

    public static HttpResponse success(Object object) {
        HttpResponse result = new HttpResponse();
        result.setCode(0);
        result.setMessage("SUCCESS");
        result.setData(object);
        return result;
    }

    public static HttpResponse success() {
        return success(null);
    }

    public static HttpResponse error(Integer code, String msg) {
        HttpResponse result = new HttpResponse();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
