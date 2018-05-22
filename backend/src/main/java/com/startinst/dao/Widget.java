package com.startinst.dao;


import com.startinst.enums.WidgetTypeEnum;
import com.startinst.utils.SnowFlakeUtil;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public class Widget {

    private Long id;

    private Long pageId;

    /**
     * Widget在第几列
     */
    private Integer posX;

    /**
     * Widget在第几行
     */
    private Integer posY;

    private String title;

    private List<Item> itemList;

    private Page page;

    private String description;

    /**
     * Widget的类型，书签、笔记、广告
     */
    private WidgetTypeEnum widgetType;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;


    public long getId() {
        return this.id;
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
                "pageId: "+this.pageId+", "+
                "itemType: "+this.widgetType+", "+
                "title: "+this.title+", "+
                "description: "+this.description+", "+
                "itemList: "+this.getItemList()+", "+
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

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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
}
