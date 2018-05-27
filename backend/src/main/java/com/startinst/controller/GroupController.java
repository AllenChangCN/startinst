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
@RequestMapping(value = "/api/groups")
public class GroupController {


    @GetMapping(value = "/{group_id}/info")
    public HttpResponse info(@PathVariable("group_id") Long userId){
        return HttpResponseUtil.success(userId);
    }


}
