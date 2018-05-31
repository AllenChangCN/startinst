package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.dao.Tag;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.PageTagMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.PageCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageService
{


    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    PageTagMapper pageTagMapper;

    @Autowired
    TagService tagService;

    /**
     * 根据PageId获取Page的Json Content
     * @return Page
     */
    public Page fetchPageInfo(Long id)
    {
        //  关联映射的方式，获得Widget数据
        return pageMapper.findByIdWithWidget(id);
    }

    public List<Widget> fetchPageItems(Long id)
    {
        return widgetMapper.findByPageIdWithItemList(id);
    }

    /**
     * 创建一个页面(包含Tag等信息)
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public Page create(PageCreateModel pageCreateModel) throws RuntimeException
    {
        List<Tag> tagList = new ArrayList<Tag>();

        System.out.println(pageCreateModel.getTagIdList());

        for (Long tagId : pageCreateModel.getTagIdList())
        {
            Tag tag = tagService.findTagById(tagId);
            if(tag != null)
            {
                tagList.add(tag);
            }
        }

        Page page = new Page();
        page.setCreatedAt(new Date());
        page.setId();
        page.setTagList(tagList);
        page.setIsOpen(pageCreateModel.getIsOpen());
        page.setTitle(pageCreateModel.getTitle());
        page.setDescription(pageCreateModel.getDescription());
        page.setUserId(pageCreateModel.getUserId());
        if (pageMapper.insert(page) > 0)
        {
            return page;
        } else {
            return null;
        }
    }

}
