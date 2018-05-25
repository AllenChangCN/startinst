package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.enums.ItemTypeEnum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ItemMapperTest {

    private Long testWidgetId = 999999999999999999L;
    Long testPageId = 999999999999999999L;

    @Autowired(required = true)
    private ItemMapper itemMapper;

    Long func_insert()
    {
        // 添加一条数据
        Item item = new Item();
        item.setId();
        Long testItemId = item.getId();
        item.setContent("content");
        item.setItemType(ItemTypeEnum.LINK);
        item.setUpdatedAt(null);
        item.setPageId(testPageId);
        item.setWidgetId(testWidgetId);
        item.setCreatedAt(new Date());
        int effectLine = itemMapper.insert(item);
        assertEquals(effectLine, 1);
        return testItemId;
    }

    void insert()
    {
        this.func_insert();
    }

    @Test
    void insertDeleteUpdate() {
        // 先删除已有的测试Id
        itemMapper.deleteItemByWidgetId(testWidgetId);

        Long testItemId = this.func_insert();

        // 更新一条数据
        Item item1 = new Item();
        item1.setId(testItemId);
        item1.setContent("update_content");
        item1.setTitle("new title");
        item1.setDescription("update_item_test");
        item1.setUpdatedAt(new Date());
        int effectLine = itemMapper.updateContent(item1);
        assertTrue(effectLine > 0);

        // 查询一条数据
        Item find_item = itemMapper.findByIdWithWidget(testItemId);
        // 看有没有查询到数据
        assertTrue(find_item != null);
        assertTrue(find_item.toString().length() > 7);
        System.out.println(find_item);

        // findByWidgetId
        List<Item> items = itemMapper.findByWidgetId(this.testWidgetId);
        assertTrue(items.size() >= 1);
//        System.out.println(Arrays.toString(items.toArray()));

        // 删除数据
        itemMapper.softDelete(testWidgetId, new Date());
        effectLine = itemMapper.deleteItemByWidgetId(testWidgetId);
        assertTrue(effectLine > 0);  // 删除
        this.func_insert();
    }

    @Test
    void findByPageId()
    {
        List<Item> items = itemMapper.findByPageId(testPageId);
        assertTrue(items.size() > 0);
    }



}