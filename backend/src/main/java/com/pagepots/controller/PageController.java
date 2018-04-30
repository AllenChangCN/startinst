package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpJsonResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping("/api/page")
public class PageController {
    /**
     * 起始页
     *
     * @return String
     */
    @GetMapping("/start-page")
    public HttpResponse startPage(){
        return HttpJsonResultUtil.success(new ArrayList<List>());
    }
}
