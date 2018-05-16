package com.startinst.controller;

import com.startinst.domain.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuancheng
 */
@Api(value = "用户资源API",description = "")
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "Integer")
    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "/{user_id}/info")
    public HttpResponse info(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success(userId);
    }


    @ApiOperation(value = "登录用户的首页")
    @ApiImplicitParam(name = "user_id", required = true, dataType = "Integer")
    @GetMapping("/{user_id}/home")
    public HttpResponse startPage(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success();
    }

}
