package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import com.pagepots.utils.SnowFlakeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuancheng
 */
@Api(value = "用户资源API")
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
