package com.startinst.service.impl;

import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.PageTagMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.PageCreateModel;
import com.startinst.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
public class PageServiceImpl implements IService
{


    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    PageTagMapper pageTagMapper;

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
    public void create(PageCreateModel pageCreateModel) throws RuntimeException
    {
        Page page = new Page();
        page.setCreatedAt(new Date());
        page.setId();
        page.setIsOpen(pageCreateModel.getIsOpen());
        page.setTitle(pageCreateModel.getTitle());
        page.setDescription(pageCreateModel.getDescription());
        page.setUserId(pageCreateModel.getUserId());
        pageMapper.insert(page);
    }

}
