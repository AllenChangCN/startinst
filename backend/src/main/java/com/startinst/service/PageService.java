package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.dao.PageTag;
import com.startinst.dao.Tag;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.*;
import com.startinst.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageService
{


    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    PageTagMapper pageTagMapper;

    @Autowired
    TagService tagService;

    /**
     * 根据PageId获取Page的Json Content
     * @return Page
     */
    public Page fetchPageInfo(Long id)
    {
        //  关联映射的方式，获得Widget数据
        return pageMapper.findByIdWithWidget(id);
    }

    public List<Widget> fetchPageItems(Long id)
    {
        return widgetMapper.findByPageIdWithItemList(id);
    }

    /**
     * 创建一个页面(包含Tag等信息)
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public Page create(PageModel pageCreateModel) throws RuntimeException
    {
        // 添加页面
        Page page = new Page();
        page.setCreatedAt(new Date());
        page.setId();
        page.setIsOpen(pageCreateModel.getIsOpen());
        page.setTitle(pageCreateModel.getTitle());
        page.setDescription(pageCreateModel.getDescription());
        page.setUserId(pageCreateModel.getUserId());
        page.setFavorite(0);
        if (pageMapper.insert(page) > 0)
        {
            // 关联Page Tag, 如果Tag不存在就忽略
            for (Long tagId : pageCreateModel.getTagIdList())
            {
                Tag tag = tagService.findTagById(tagId);
                if(tag != null)
                {
                    // 关联对应的Tag
                    PageTag pageTag = new PageTag();
                    pageTag.setTagId(tagId);
                    pageTag.setPageId(page.getId());
                    pageTag.setCreatedAt(new Date());
                    pageTagMapper.insert(pageTag);
                    // 刷新Tag使用量
                    tagMapper.refreshUseCount(tagId);
                }
            }
            return page;
        } else {
            throw new RuntimeException("页面创建失败");
        }
    }

    /**
     * 删除一个Page
     * @param pageId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void forceDelete(Long pageId)
    {
        pageMapper.delete(pageId);
        pageTagMapper.delete(pageId);
    }

}
