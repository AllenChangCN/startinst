package com.pagepots.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String say(){
        return "hello spring boot";
    }
    @RequestMapping(value = "/abc",method = RequestMethod.GET)
    public String good(){
        return "abc";
    }
}
