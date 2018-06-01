package com.startinst.model;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author liuyuancheng
 */
public class TagCreateModel {

    private String name;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
