package com.startinst.model;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author liuyuancheng
 */
public class WidgetModel {

    private Long userId;

    private String title;

    private String description;

    private Boolean isOpen;

    private List<Long> tagIdList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
