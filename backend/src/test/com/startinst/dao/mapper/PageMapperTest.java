package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import com.startinst.enums.ItemTypeEnum;
import com.startinst.enums.WidgetTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PageMapperTest {

    Long testPageId = 999999999999999999L;
    Long testWidgetId = 999999999999999999L;

    @Autowired
    private WidgetMapper widgetMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private PageMapper pageMapper;

    @Test
    void findByIdWithWidgetNestData()
    {
        Page page = pageMapper.findByIdWithWidget(testPageId);
        assertTrue(page.getWidgetList().size() >= 0);
        System.out.println(page);
    }


}