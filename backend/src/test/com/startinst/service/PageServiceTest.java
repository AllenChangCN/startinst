package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.service.impl.PageServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PageServiceTest {

    private PageServiceImpl pageService;

    private Long testPageId = 999999999999999999L;

    private Long testUserid = 999999999999999999L;

    @Test
    void fetchPageInfo()
    {
        Page widgetList = pageService.fetchPageInfo(testPageId);
        System.out.println(widgetList);
    }


}
