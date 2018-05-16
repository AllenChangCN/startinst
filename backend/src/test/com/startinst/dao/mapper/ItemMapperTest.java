package com.startinst.dao.mapper;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper ItemMapper;

    @Test
    public void findByWidgetId() {
        ItemMapper.findByWidgetId(1L);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }
}