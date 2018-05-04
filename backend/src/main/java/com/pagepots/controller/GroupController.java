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
@Api(value = "用户组资源API")
@RestController
@RequestMapping(value = "/api/groups")
public class GroupController {


    @ApiImplicitParam(name = "group_id", value = "用户ID", required = true, dataType = "Integer")
    @ApiOperation(value = "获取用户组信息")
    @GetMapping(value = "/{group_id}/info")
    public HttpResponse info(@PathVariable("group_id") Long userId){
        return HttpResponseUtil.success(userId);
    }


}
