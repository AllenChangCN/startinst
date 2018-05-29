package com.startinst.dao.mapper;

import com.startinst.dao.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PageListMapperTest {

    Long testPageId = 999999999999999999L;
    Long testWidgetId = 999999999999999999L;

    @Autowired
    private UserFavorPageMapper userFavorPageMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private PageMapper pageMapper;




}