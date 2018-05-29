package com.startinst.dao;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startinst.utils.SnowFlakeUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class UserFavorPage implements Serializable{

    private Long id;

    private Long userId;

    private Long pageId;

    private Page page;

    private Date createdAt;

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

    @Override
    public String toString() {
        return  "Id: "+this.id+", "+
                "pageId:"+ this.pageId+", "+
                "userId:"+ this.userId+", "+
                "createdAt: "+this.createdAt;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }
}
