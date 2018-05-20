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

    private Long testId = 999999999999999999L;

    @Autowired(required = true)
    private ItemMapper itemMapper;

    @Test
    void curd() {
        // 先删除已有的测试Id
        itemMapper.forceDelete(testId);

        // 添加一条数据
        Item item = new Item();
        item.setId(testId);
        item.setContent("content");
        item.setItemType(ItemTypeEnum.LINK);
        item.setUpdatedAt(null);
        item.setWidgetId(1L);
        item.setCreatedAt(new Date());
        int effectLine = itemMapper.insert(item);
        assertEquals(effectLine, 1);

        // 查询一条数据
        Item find_item = itemMapper.findOne(testId);
        assertTrue(find_item.toString().length() > 7);

        // 更新一条数据
        Item item1 = new Item();
        item1.setId(testId);
        item1.setContent("update_content");
        item1.setTitle("new title");
        item1.setDescription("my description");
        item1.setUpdatedAt(new Date());
        effectLine = itemMapper.updateContent(item1);
        assertEquals(effectLine,1);

        // findByWidgetId
        List<Item> items = itemMapper.findByWidgetId(1L);
        assertTrue(items.size() >= 1);
        System.out.println(Arrays.toString(items.toArray()));

        // 删除数据
        itemMapper.delete(testId, new Date());
        effectLine = itemMapper.forceDelete(testId);
        assertEquals(effectLine, 1);  // 删除
    }



}