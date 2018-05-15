package com.startinst.controller;

import com.startinst.domain.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@RestController
@Api(value = "Discover资源API",description = "")
@RequestMapping("/api/discovers")

public class DiscoverController {

    @ApiOperation(value = "发现网页")
    @GetMapping(value = "page")
    public HttpResponse page(){
        return HttpResponseUtil.success();
    }

    @ApiOperation(value = "页面信息")
    @GetMapping(value = "page/site/detail")
    public HttpResponse pageInfo(){
        return HttpResponseUtil.success();
    }

    @ApiOperation(value = "发现热门站点")
    @GetMapping(value = "hot-site")
    public HttpResponse hotSite(){
        return HttpResponseUtil.success();
    }
}
