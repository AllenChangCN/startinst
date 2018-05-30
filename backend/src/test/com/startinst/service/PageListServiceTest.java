package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.service.impl.PageListServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PageListServiceTest {

    @Autowired
    private PageListServiceImpl pageListService;

    private Long testPageId = 999999999999999999L;

    private Long testUserId = 999999999999999999L;

    @Test
    void fetchPageListByUserId()
    {
        List<Page> pageList = pageListService.fetchPageListByUserId(testUserId);
        System.out.println(pageList);
    }

}
