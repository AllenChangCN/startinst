package com.startinst.model;

import com.startinst.dao.Tag;

import java.util.List;

/**
 * @author liuyuancheng
 */
public class PageModel {

    private String title;

    private List<Tag> tagList;

    private String description;

    private Integer isOpen;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer isOpen() {
        return isOpen;
    }

    public void setOpen(int open) {
        isOpen = open;
    }
}
