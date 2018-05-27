package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping("/api/discovers")
//@RequiresAuthentication
public class DiscoverController {

    @GetMapping(value = "page")
    public HttpResponse page(){
        return HttpResponseUtil.success();
    }

    @GetMapping(value = "page/site/detail")
    public HttpResponse pageInfo(){
        return HttpResponseUtil.success();
    }

    @GetMapping(value = "hot-site")
    public HttpResponse hotSite(){
        return HttpResponseUtil.success();
    }
}
