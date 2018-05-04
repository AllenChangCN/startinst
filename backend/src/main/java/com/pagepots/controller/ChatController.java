package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@Api(value = "Chat资源API",description = "聊天信息")
@RestController
@RequestMapping(value = "/api/chats")
public class ChatController {

    @ApiImplicitParam(name = "page_id", value = "用户ID", required = true, dataType = "Integer")
    @ApiOperation(value = "获取页面Chats列表")
    @GetMapping(value = "/chats/{page_id}")
    public HttpResponse info(@PathVariable("page_id") Long pageId){
        return HttpResponseUtil.success(pageId);
    }

}
