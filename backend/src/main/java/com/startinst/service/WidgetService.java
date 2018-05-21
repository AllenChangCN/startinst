package com.startinst.service;

import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class WidgetService {

    @Autowired
    WidgetMapper widgetMapper;

    /**
     * 根据PageId获取
     *
     * @param pageId
     * @return Item[]
     */
    public String findWidgetByPageId(Integer pageId)
    {
        //  关联映射的方式，获得Widget数据

        return "";
    }

}
