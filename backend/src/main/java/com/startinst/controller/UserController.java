package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @GetMapping(value = "/{user_id}/info")
    public HttpResponse info(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success(userId);
    }


    @GetMapping("/{user_id}/home")
    public HttpResponse startPage(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success();
    }

}
