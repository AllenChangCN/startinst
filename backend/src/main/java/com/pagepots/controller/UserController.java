package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import com.pagepots.utils.SnowFlakeUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户资源
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    /**
     * 用户信息
     * @return HttpResponse
     */
    @GetMapping(value = "/{user_id}/user-info")
    public HttpResponse info(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success(userId);
    }

    /**
     * 起始页,包含页面相关的很多信息
     *
     * @return String
     */
    @GetMapping("/{user_id}/start-page")
    public HttpResponse startPage(@PathVariable("user_id") Long userId){
        return HttpResponseUtil.success(new ArrayList<List>());
    }

}
