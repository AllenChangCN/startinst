package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    /**
     * 根据PageId获取Page的Json Content
     * @return Map<Integer, Widget>[][] 二维数组
     */
    public String findPageById(Integer id)
    {
        //  关联映射的方式，获得Widget数据

        return "";
    }

    /**
     * 创建一个页面
     * @return HttpResponse
     */
    public String createPage()
    {
        return "";
    }

    /**
     * 更新页面Widget排序
     * @return HttpResponse
     */
    public String updatePageSort()
    {
        return "";
    }

    public String pageSearch()
    {
        return "";
    }

}
