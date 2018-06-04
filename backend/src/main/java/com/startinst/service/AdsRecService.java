package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告推荐服务
 *
 * @author liuyuancheng
 */
@Service
public class AdsRecService {

    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    ItemMapper itemMapper;

    /**
     * 根据widgetId获取，以Widget为单位缓存Item，并在Item修改时只更新相关Widget
     *
     * @param widgetId
     * @return Item[]
     */
    @Cacheable(value = "items", key = "#widgetId")
    public List<Item> fetchItemOfOneWidget(Long widgetId)
    {
        return itemMapper.findByWidgetId(widgetId);
    }


}
