package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Tag;
import com.startinst.model.TagCreateModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TagServiceTest {

    private Long testWidgetId = 999999999999999999L;

    private Long testPageId = 999999999999999999L;

    @Autowired
    private TagService tagService;

    @Test
    @Transactional
    void create()
    {
        TagCreateModel tagCreateModel = new TagCreateModel();
        tagCreateModel.setName("testTag");
        Tag tag = tagService.create(tagCreateModel);
        System.out.println(tag);
    }
}
