package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/chats")
public class ChatController {

    @GetMapping(value = "/chats/{page_id}")
    public HttpResponse info(@PathVariable("page_id") Long pageId){
        return HttpResponseUtil.success(pageId);
    }

}
