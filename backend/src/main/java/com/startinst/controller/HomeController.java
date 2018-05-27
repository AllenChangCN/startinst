package com.startinst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户资源
 * @author liuyuancheng
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String login(){
        logger.info("show home page");
        return "Home Page2.";
    }
}
