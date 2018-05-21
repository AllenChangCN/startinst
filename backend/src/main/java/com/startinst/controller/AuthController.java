package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.model.LoginModel;
import com.startinst.enums.HttpResponseCodeEnum;
import com.startinst.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户资源
 * @author liuyuancheng
 */
@RestController
@Api(value="Auth认证API",description = "用户认证的所有需求")
@RequestMapping(value = "/api/auth")
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @ApiOperation(value = "用户登录", notes = "需要输入用户名和密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",required = true,dataType = "String")
    })
    @PostMapping(value = "login")
    public HttpResponse login(@ModelAttribute LoginModel loginModel){
        logger.info("登录");
        // 检查密码合法性
        if(loginModel.getUsername() == null || loginModel.getUsername().isEmpty()){
            return HttpResponseUtil.error(HttpResponseCodeEnum.ERR_USERNAME_CANNOT_BE_EMPTY);
        }
        if(loginModel.getPassword() == null || loginModel.getPassword().isEmpty()){
            return HttpResponseUtil.error(HttpResponseCodeEnum.ERR_PASSWORD_CANNOT_BE_EMPTY);
        }
        return HttpResponseUtil.success(loginModel.getUsername() + "登录成功");
    }
}
