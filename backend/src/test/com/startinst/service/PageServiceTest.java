package com.startinst.service;

import com.startinst.dao.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PageServiceTest {

    @Autowired
    private PageService pageService;

    private Long testPageId = 999999999999999999L;

    private Long testUserid = 999999999999999999L;

    @Test
    void fetchPageInfo()
    {
        Page widgetList = pageService.fetchPageInfo(testPageId);
        System.out.println(widgetList);
    }


}
