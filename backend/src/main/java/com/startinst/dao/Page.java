package com.startinst.dao;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.*;
import com.startinst.utils.SnowFlakeUtil;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Page implements Serializable{

    private Long id;

    /**
     * 页面是否公开访问
     */
    private Integer isOpen;

    private Long userId;

    /**
     * 最常用的页面，在用户首页轮播显示；0-排在首页其余依次，默认为null
     */
    private Integer favorite;

    private String title;

    private String description;

    private List<Widget> widgetList;

    private List<Tag> tagList;

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
        return JSON.toJSONString(this);
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

    public List<Widget> getWidgetList() {
        return widgetList;
    }

    public void setWidgetList(List<Widget> widgetList) {
        this.widgetList = widgetList;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
