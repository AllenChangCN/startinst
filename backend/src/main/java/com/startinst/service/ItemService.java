package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
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
public class ItemService {

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

    /**
     * 以Widget为单位，获取itemList
     * @param pageId
     * @return
     */
    public Map<Long,List<Item>> fetchWidgetListWithItems(Long pageId)
    {
        HashMap hashMap = new HashMap();
        List<Long> widgetIdListOfPage = widgetMapper.findWidgetIdListByPageId(pageId);
        for (int i=0;i<widgetIdListOfPage.size();i++){
            Long currentWidgetId = widgetIdListOfPage.get(i);
            hashMap.put(currentWidgetId,this.fetchItemOfOneWidget(currentWidgetId));
        }
        return hashMap;
    }

    public String editItemOfWidget(Long widgetId, Long itemId)
    {
        return "";
    }

}
