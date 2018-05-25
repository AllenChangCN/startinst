package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import com.startinst.enums.ItemTypeEnum;
import com.startinst.enums.WidgetTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WidgetMapperTest {

    Long testPageId = 999999999999999999L;
    Long testWidgetId = 999999999999999999L;

    @Autowired
    private WidgetMapper widgetMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Test
    void findWidgetById()
    {
        Item item = new Item();
        item.setId();
        item.setWidgetId(testWidgetId);
        item.setTitle("widget title");
        item.setDescription("widget desc");
        item.setContent("content item");
        item.setItemType(ItemTypeEnum.NOTE);
        item.setCreatedAt(new Date());
        itemMapper.insert(item);
        Widget widget1 = widgetMapper.findById(testWidgetId);
        assertTrue(widget1 != null);
        if(widget1 != null)
        {
            System.out.println(widget1.getItemList());
        }
    }

    @Test
    void insertAndUpdate() {
        int effect;
        // insert
        Widget widget = new Widget();
        widget.setId();
        Long testWidgetId = widget.getId();
        widget.setTitle("测试Widget Title");
        widget.setPageId(testPageId);
        widget.setWidgetType(WidgetTypeEnum.NOTE);
        widget.setDescription("测试Widget Desc");
        widget.setCreatedAt(new Date());

        // 判断是否插入重构
        effect = widgetMapper.insert(widget);
        assertTrue(effect > 0);

        // update
        Widget widget2 = widgetMapper.findById(testWidgetId);
        widget2.setTitle("title_update_test");
        widget2.setUpdatedAt(new Date());
        System.out.println(widget2);
        assertTrue(widget2.getId() > 0L);
        effect = widgetMapper.updateInfo(widget2);
        assertTrue(effect > 0);

        // 验证沟通成果
        Widget widget3 = widgetMapper.findById(widget.getId());
        assertTrue(widget3.toString().indexOf("title_update_test") > 0);
    }

    @Test
    void updateWidgetPosById(){
        Random random = new Random(100);
        int effect = widgetMapper.updateWidgetPosById(testWidgetId,random.nextInt(100),random.nextInt(100));
        assertTrue(effect > 0);
    }

    @Test
    void updateWidgetSize()
    {
        int effect = widgetMapper.updateWidgetSize(testWidgetId);
        assertTrue(effect >= 0);
    }

    @Test
    void findWidgetIdListByPageId()
    {
        List<Long> widgetIdList = widgetMapper.findWidgetIdListByPageId(testPageId);
        System.out.println(widgetIdList);
    }


}