package com.startinst.service.impl;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class WidgetServiceImpl {

    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    ItemMapper itemMapper;

    /**
     * 移动Widget的位置
     *
     * @param originWidget
     * @param targetWdiget
     * @return
     */
    public String moveWidgetPos(Widget originWidget,Widget targetWdiget)
    {
        return "";
    }

}
