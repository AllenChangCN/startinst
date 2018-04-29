package com.pagepots.controller;

import com.pagepots.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

/**
 * 用户资源
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @GetMapping(value = "hello")
    public Long hello(){
        return SnowFlake.getId();
    }
}
