package com.startinst.controller;

import com.startinst.dao.Tag;
import com.startinst.model.HttpResponse;
import com.startinst.service.TagService;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/tag")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 根据关键词搜索标签
     * @param keyword
     * @return
     */
    @GetMapping(value = "/search")
    public HttpResponse searchKeyword(@RequestParam(value = "keyword",required = true) String keyword)
    {
        List<Tag> tagList = new ArrayList<>();
        if(keyword.isEmpty())
        {
            tagList = tagService.hotList();
        } else {
            tagList = tagService.keywordList(keyword);
        }
        return HttpResponseUtil.success(tagList);
    }

}
