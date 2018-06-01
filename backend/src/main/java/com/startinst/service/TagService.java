package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Tag;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.TagMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.TagCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class TagService
{

    @Autowired
    TagMapper tagMapper;

    public Tag findTagById(Long id)
    {
        return tagMapper.findById(id);
    }

    /**
     * 创建一个新的Tag
     *
     * @param tagCreateModel
     */
    public Tag create(TagCreateModel tagCreateModel) throws RuntimeException
    {
        Tag tag = new Tag();
        tag.setName(tagCreateModel.getName());
        tag.setCreatedAt(new Date());
        tag.setId();
        tag.setUseCount(0);
        tag.setType(0);
        int effect = tagMapper.insert(tag);
        if (effect > 0)
        {
            return tag;
        }else{
            throw new RuntimeException("创建Tag失败");
        }
    }

    /**
     * 根据关键词推荐Tag列表
     * @param keyword
     */
    public List<Tag> keywordList(String keyword)
    {
        return tagMapper.findTagListByKeyword(keyword.trim()+'%');
    }

    public List<Tag> hotList()
    {
        return tagMapper.findTagListOfTop10Usage();
    }

}
