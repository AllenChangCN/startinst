package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.enums.ItemTypeEnum;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Autowired(required = true)
    private ItemMapper ItemMapper;

    @Test
    public void insert() {
        Item item = new Item();
        item.setId();
        item.setContent("content");
        item.setItemType(ItemTypeEnum.BOOKMARK);
        item.setupdatedAt(null);
        item.setWidgetId(1L);
        item.setCreatedAt(new Date());
        ItemMapper.insert(item);
    }

    @Test
    public void findOne() {
//        System.out.println(ItemTypeEnum.BOOKMARK);
    }



    @Test
    public void update() {
    }

    @Test
    public void findByWidgetId() {
        ItemMapper.findByWidgetId(1L);
    }


}