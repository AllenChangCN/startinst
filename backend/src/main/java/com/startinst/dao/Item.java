package com.startinst.dao;


import com.fasterxml.jackson.annotation.*;
import com.startinst.enums.ItemTypeEnum;
import com.startinst.utils.SnowFlakeUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

/**
 * @author liuyuancheng
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Item {

    private Long id;

    private Long widgetId;

    private Long pageId;

    private Widget widget;

    private String title;

    private String description;

    private String content;

    private ItemTypeEnum itemType;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    public long getId() {
        return id;
    }

    /**
     * Snowflake算法生成Id
     */
    public void setId() {
        this.id = SnowFlakeUtil.getId();
    }

    /**
     * 指定Id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  "Id: "+this.id+", "+
                "widgetId: "+this.widgetId+", "+
                "pageId: "+this.pageId+", "+
                "itemType: "+this.itemType+", "+
                "title: "+this.title+", "+
                "description: "+this.description+", "+
                "content: "+this.content+", "+
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }
}
