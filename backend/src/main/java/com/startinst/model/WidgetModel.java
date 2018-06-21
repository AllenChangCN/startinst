package com.startinst.model;

import com.alibaba.fastjson.JSON;
import com.startinst.enums.WidgetTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public class WidgetModel {

    private Long id;

    private String title;

    private String description;

    private Integer posX;

    private Integer posY;

    private Long pageId;

    private WidgetTypeEnum widgetType;

    private Date createdAt;

    private Date updatedAt;

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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public WidgetTypeEnum getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(WidgetTypeEnum widgetType) {
        this.widgetType = widgetType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
