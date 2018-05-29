package com.startinst.dao;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startinst.enums.ItemTypeEnum;
import com.startinst.utils.SnowFlakeUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyuancheng
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Tag implements Serializable{

    private Long id;

    private Long type;

    private String title;

    private String content;

    private String description;

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



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  "Id: "+this.id+", "+
                "title: "+this.title+", "+
                "description: "+this.description+", "+
                "content: "+this.content+", "+
                "createdAt: "+this.createdAt;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
