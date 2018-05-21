package com.startinst.dao;


import com.startinst.enums.WidgetTypeEnum;
import com.startinst.utils.SnowFlakeUtil;

import java.util.Date;

/**
 * @author liuyuancheng
 */
public class Widget {

    private Long id;

    private Long pageId;

    private String title;

    private String description;

    /**
     * Item数据的排布，矩阵数组排布，值为Item的Id
     */
    private String itemsSort;

    /**
     * Widget的类型，书签、笔记、广告
     */
    private WidgetTypeEnum widgetType;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    public long getId() {
        return id;
    }

    /**
     * Snowflake算法生成Id
     */
    public Long setId() {
        this.id = SnowFlakeUtil.getId();
        return this.id;
    }

    /**
     * 指定Id
     * @param id
     */
    public Long setId(Long id) {
        this.id = id;
        return id;
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

    @Override
    public String toString() {
        return  "Id: "+this.id+", "+
                "widgetId: "+this.pageId+", "+
                "itemType: "+this.widgetType+", "+
                "title: "+this.title+", "+
                "description: "+this.description+", "+
                "createdAt: "+this.createdAt+", "+
                "updatedAt: "+this.updatedAt+"\n";
    }

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

    public WidgetTypeEnum getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(WidgetTypeEnum widgetType) {
        this.widgetType = widgetType;
    }

    public Long getPageId() {
        return pageId;
    }

    public Long setPageId(Long pageId) {
        this.pageId = pageId;
        return pageId;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getItemsSort() {
        return itemsSort;
    }

    public void setItemsSort(String itemsSort) {
        this.itemsSort = itemsSort;
    }
}
