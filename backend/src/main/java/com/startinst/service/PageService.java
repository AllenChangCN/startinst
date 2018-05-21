package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.domain.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.stereotype.Service;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageService {

    /**
     * 根据PageId获取Page的Json Content
     * @return HttpResponse
     */
    public HttpResponse findPageById()
    {
        return HttpResponseUtil.success();
    }

    /**
     * 创建一个页面
     * @return HttpResponse
     */
    public HttpResponse createPage()
    {
        return HttpResponseUtil.success();
    }

    /**
     * 更新页面Widget排序
     * @return HttpResponse
     */
    public HttpResponse updatePageSort()
    {
        return HttpResponseUtil.success();
    }

    public String pageSearch()
    {
        return "";
    }

}
