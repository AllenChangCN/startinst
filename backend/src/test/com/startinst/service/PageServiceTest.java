package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.model.PageCreateModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Test
//    @Transactional
    void createPage()
    {
        List<Long> tagIdList = new ArrayList<>();
        tagIdList.add(testPageId);
        tagIdList.add(222L);
        PageCreateModel pageCreateModel = new PageCreateModel();
        pageCreateModel.setIsOpen(1);
        pageCreateModel.setDescription("desc");
        pageCreateModel.setTagIdList(tagIdList);
        pageCreateModel.setTitle("title");
        pageCreateModel.setUserId(testUserid);
        pageService.create(pageCreateModel);
    }


}
