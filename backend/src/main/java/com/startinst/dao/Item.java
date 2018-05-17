package com.startinst.dao;


import com.startinst.enums.ItemTypeEnum;
import com.startinst.utils.SnowFlakeUtil;

import java.util.Date;

/**
 * @author liuyuancheng
 */
public class Item {

    private Long id;

    private Long widgetId;

    private String content;

    private ItemTypeEnum itemType;

    private Date updatedAt;

    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = SnowFlakeUtil.getId();
    }

    public ItemTypeEnum getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypeEnum itemType) {
        this.itemType = itemType;
    }

    public long getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(Long widgetId) {
        this.widgetId = widgetId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
