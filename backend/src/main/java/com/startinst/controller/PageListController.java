package com.startinst.controller;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
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
public class PageListController {

    @Autowired
    private PageListService pageListService;

    @GetMapping("mylist/for-user/{user_id}")
    public HttpResponse pageMyList(@PathVariable("user_id") Long userId)
    {
        List<Page> myListData = pageListService.fetchPageListByUserId(userId);
        return HttpResponseUtil.success(myListData);
    }

}