package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Tag;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.TagMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class TagService {

    @Autowired
    TagMapper tagMapper;

    public boolean isTagExists(Long id)
    {
        return tagMapper.findById(id)!=null;
    }

    /**
     * 创建一个新的Tag
     *
     * @param tag
     */
    public void create(Tag tag)
    {

    }

    /**
     * 根据关键词推荐Tag列表
     * @param keywords
     */
    public void keywordRecommend(String keywords)
    {

    }

    public void hotRecommend()
    {

    }

}
