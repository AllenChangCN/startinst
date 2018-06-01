package com.startinst.service;

import com.alibaba.fastjson.JSON;
import com.startinst.dao.Page;
import com.startinst.dao.PageTag;
import com.startinst.dao.mapper.PageTagMapper;
import com.startinst.model.PageCreateModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PageServiceTest {

    @Autowired
    private PageService pageService;

    @Autowired
    private PageTagMapper pageTagMapper;

    private Long testPageId = 999999999999999999L;

    private Long testUserid = 999999999999999999L;


    @Test
    void fetchPageInfo()
    {
        Page widgetList = pageService.fetchPageInfo(testPageId);
        System.out.println(widgetList);
    }

    @Test
    @Transactional
    void createPage()
    {

        List<Long> tagIdList = new ArrayList<>();
        tagIdList.add(testPageId);
        tagIdList.add(222L);
        PageCreateModel pageCreateModel = new PageCreateModel();
        pageCreateModel.setIsOpen(0);
        pageCreateModel.setDescription("desc");
        pageCreateModel.setTagIdList(tagIdList);
        pageCreateModel.setTitle("title");
        pageCreateModel.setUserId(testUserid);
        Page page = pageService.create(pageCreateModel);
        List<PageTag> pageTags = pageTagMapper.findByPageId(page.getId());
        assertTrue("", pageTags != null);
        System.out.println(pageTags);
        System.out.println(page);
    }

    @Test
    @Transactional
    void forceDelete()
    {

    }




}
