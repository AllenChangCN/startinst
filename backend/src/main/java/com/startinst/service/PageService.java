package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageService {


    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    ItemMapper itemMapper;

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
     * 创建一个页面
     * @return Boolean
     */
    public Boolean updatePageInfo() throws RuntimeException
    {
        return true;
    }

}
