package com.pagepots.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户资源
 * @author liuyuancheng
 */
@Api(value="用户认证API",tags={""})
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @ApiOperation(value = "用户登录",notes = "需要输入用户名和密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",required = true,dataType = "String")
    })
    @PostMapping(value = "login")
    public String login(){
        logger.error("infomation");
        return "sadf";
    }
}
