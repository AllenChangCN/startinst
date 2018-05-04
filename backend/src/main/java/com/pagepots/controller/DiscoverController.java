package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */

@Api(value = "Discover资源API")
@RestController
@RequestMapping("/api/discovers")
public class DiscoverController {

    @ApiOperation(value = "发现网页")
    @GetMapping(value = "page")
    public HttpResponse page(){
        return HttpResponseUtil.success();
    }

    @ApiOperation(value = "发现热门站点")
    @GetMapping(value = "hot-site")
    public HttpResponse hotSite(){
        return HttpResponseUtil.success();
    }
}
