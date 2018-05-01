package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发现
 * @author liuyuancheng
 */
@RestController
@RequestMapping("/api/discovers")
public class DiscoverController {
    /**
     * 发现
     * @return
     */
    @RequestMapping
    public HttpResponse discover(){
        return HttpResponseUtil.success();
    }
}
