package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.enums.ItemTypeEnum;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemMapperTest {

    Long testId = 999999999999999999L;

    @Autowired(required = true)
    private ItemMapper ItemMapper;

    @Test
    public void curd() {
        // 先删除已有的测试Id
        ItemMapper.forceDelete(testId);

        // 添加一条数据
        Item item = new Item();
        item.setId(testId);
        item.setContent("content");
        item.setItemType(ItemTypeEnum.LINK);
        item.setUpdatedAt(null);
        item.setWidgetId(1L);
        item.setCreatedAt(new Date());
        int effectLine = ItemMapper.insert(item);
        assertEquals(effectLine, 1);

        // 查询一条数据
        Item find_item = ItemMapper.findOne(testId);
        assertTrue("ItemMapper.findOne出错",find_item.toString().length() > 7);

        // 更新一条数据
        Item item1 = new Item();
        item1.setId(testId);
        item1.setContent("update_content");
        item1.setTitle("new title");
        item1.setDescription("my description");
        item1.setUpdatedAt(new Date());
        effectLine = ItemMapper.updateContent(item1);
        assertEquals(effectLine,1);

        // findByWidgetId
        List<Item> items = ItemMapper.findByWidgetId(1L);
        assertTrue(items.size() >= 1);
        System.out.println(Arrays.toString(items.toArray()));

        // 删除数据
        ItemMapper.delete(testId, new Date());
        effectLine = ItemMapper.forceDelete(testId);
        assertEquals(effectLine, 1);  // 删除
    }



}