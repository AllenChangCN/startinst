package com.startinst.dao.mapper;

import com.startinst.dao.Page;
import com.startinst.dao.UserFavorPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserFavorPageMapperTest {

    Long testPageId = 999999999999999999L;
    Long testWidgetId = 999999999999999999L;

    Long testUserId = 999999999999999999L;
    Long testFavorId = 999999999999999999L;

    @Autowired
    private WidgetMapper widgetMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserFavorPageMapper userFavorPageMapper;

    @Test
    void delete()
    {

    }

    @Test
    void insert()
    {
        int affect = userFavorPageMapper.delete(testFavorId);
        assertTrue(affect >= 0);

        UserFavorPage userFavorPage = new UserFavorPage();
        userFavorPage.setId(testFavorId);
        userFavorPage.setUserId(testFavorId);
        userFavorPage.setPageId(testPageId);
        userFavorPage.setCreatedAt(new Date());
        affect = userFavorPageMapper.insert(userFavorPage);
        assertTrue(affect >= 0);
    }

    @Test
    void findUserFavorPageByUserId()
    {
        userFavorPageMapper.findUserFavorPageByUserId(testUserId);
    }


}