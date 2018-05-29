package com.startinst.controller;

import com.alibaba.fastjson.JSON;
import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import com.startinst.model.HttpResponse;
import com.startinst.service.ItemService;
import com.startinst.service.PageListService;
import com.startinst.service.PageService;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author liuyuancheng
 */

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @Autowired
    private ItemService itemService;

    @GetMapping("{page_id}/info")
    public HttpResponse pageInfo(@PathVariable("page_id") Long pageId){
        Page pageData = pageService.fetchPageInfo(pageId);
        return HttpResponseUtil.success(pageData);
    }

    @GetMapping("{page_id}/items")
    public HttpResponse pageItem(@PathVariable("page_id") Long pageId){
        Map<Long,List<Item>> pageData = itemService.fetchWidgetListWithItems(pageId);
        return HttpResponseUtil.success(pageData);
    }

    @GetMapping("{page_id}/edit-logs")
    public HttpResponse showLog(@PathVariable("page_id") Long pageId){
        return HttpResponseUtil.success();
    }
}
