package com.startinst.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.startinst.dao.Page;
import com.startinst.model.HttpResponse;
import com.startinst.service.PageListService;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public HttpResponse pageMyList(@PathVariable("user_id") Long userId, HttpServletRequest request)
    {
        // 准备参数
        String pages = request.getParameter("page");
        String pageSizes = request.getParameter("pageSize");
        String search = request.getParameter("search");
        pages = pages == null || pages.trim().length() == 0 ? "1":pages;
        pageSizes = pageSizes == null || pageSizes.trim().length() == 0 ? "20":pageSizes;
        Integer page = Integer.parseInt(pages);
        Integer pageSize = Integer.parseInt(pageSizes);
        // startPage(第几页, 多少条数据)
        PageHelper.startPage(page, pageSize);
        List<Page> pageList = pageListService.fetchPageListByUserId(userId,search);
        return HttpResponseUtil.success(new PageInfo<Page>(pageList));
    }

}
