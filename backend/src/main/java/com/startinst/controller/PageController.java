package com.startinst.controller;

import com.alibaba.fastjson.JSON;
import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import com.startinst.model.HttpResponse;
import com.startinst.service.ItemService;
import com.startinst.service.PageService;
import com.startinst.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

@Api(value = "Page资源API",description = "")
@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @Autowired
    private ItemService itemService;

    @ApiOperation(value="页面的内容")
    @ApiImplicitParam(value = "页面ID", required = true, dataType = "Long")
    @GetMapping("{page_id}/info")
    public HttpResponse pageInfo(@PathVariable("page_id") Long pageId){
        Page pageData = pageService.fetchPageInfo(pageId);
        return HttpResponseUtil.success(pageData);
    }

    @ApiOperation(value="页面的内容")
    @ApiImplicitParam(value = "页面ID",required = true,dataType = "Long")
    @GetMapping("{page_id}/items")
    public HttpResponse pageItem(@PathVariable("page_id") Long pageId){
        Map<Long,List<Item>> pageData = itemService.fetchWidgetListWithItems(pageId);
        return HttpResponseUtil.success(pageData);
    }

    @ApiOperation(value="页面编辑日志")
    @ApiImplicitParam(value = "页面编辑日志",required = true,dataType = "Long")
    @GetMapping("{page_id}/edit-logs")
    public HttpResponse showLog(@PathVariable("page_id") Long pageId){
        return HttpResponseUtil.success();
    }
}
