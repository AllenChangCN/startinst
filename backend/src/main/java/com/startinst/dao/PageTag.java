package com.startinst.dao;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startinst.dao.Page;
import com.startinst.utils.SnowFlakeUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyuancheng
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class PageTag implements Serializable{

    private Long id;

    private Long tagId;

    private Long pageId;

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
                "createdAt: "+this.createdAt;
    }


    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}