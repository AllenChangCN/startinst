package com.startinst.dao;


import com.alibaba.fastjson.JSON;
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


    private Long tagId;

    private Long pageId;

    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
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
