package com.startinst.dao.mapper;

import com.startinst.dao.SysRole;
import com.startinst.dao.SysUser;
import com.startinst.dao.Tag;
import com.startinst.enums.TagTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class TagsMapperTest {

    Long testId = 999999999999999999L;

    @Autowired(required = true)
    private TagMapper tagMapper;

    @Test
    void findById()
    {
        Tag tag = tagMapper.findById(11111111L);
        assertTrue("",tag == null);
    }

    @Test
    void insert()
    {
        tagMapper.softDelete(testId,new Date());
        tagMapper.delete(testId);
        Tag tag = new Tag();
        tag.setId(testId);
        tag.setType(TagTypeEnum.PAGE_TAG.getCode());
        tag.setName("技术");
        tag.setCreatedAt(new Date());
        int effect = tagMapper.insert(tag);
        System.out.println(effect);
    }

    @Test
    void update()
    {
        Tag tag = tagMapper.findById(testId);
        tag.setName("技术");
        tagMapper.update(tag);
        Tag tag1 = tagMapper.findById(testId);
        tag1.setName("技术大力");
        int effect = tagMapper.update(tag1);
        assertTrue("数据更新有误",effect >=1);
    }

    @Test
    void refreshUseCount()
    {
        Tag tag = tagMapper.findById(testId);
        System.out.println(tag.getUseCount());
        tagMapper.refreshUseCount(testId);
    }

    @Test
    void updateUseCount()
    {
        tagMapper.updateUseCount(testId);
    }

}