package com.pagepots.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户资源
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(value = "login")
    public String login(){
        logger.error("infomation");
        return "sadf";
    }
}
