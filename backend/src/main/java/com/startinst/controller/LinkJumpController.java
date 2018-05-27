package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuyuancheng
 */
@Controller
@RequestMapping(value = "/link-jump")
public class LinkJumpController {

    @GetMapping(value = "from/{page_id}/target/{target_url}")
    public HttpResponse info(@PathVariable("page_id") Long pageId,
                             @PathVariable("target_url") String targetUrl){
        return HttpResponseUtil.success();
    }

}
