package com.startinst.dao;


import com.startinst.utils.SnowFlakeUtil;

import java.util.Date;

/**
 * @author liuyuancheng
 */
public class Page {

    private Long id;

    private Long userId;

    /**
     * 最常用的页面，在用户首页轮播显示；0-排在首页其余依次，默认为null
     */
    private Integer favorite;

    private String title;

    private String description;

    /**
     * widgetId组成的行列矩阵，记录排位信息
     */
    private String widgetsSort;

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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public String getWidgetsSort() {
        return widgetsSort;
    }

    public void setWidgetsSort(String widgetsSort) {
        this.widgetsSort = widgetsSort;
    }
}
