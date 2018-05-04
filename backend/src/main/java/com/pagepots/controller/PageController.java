package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuancheng
 */
@RestController
@RequestMapping("/api/pages")
public class PageController {

    @ApiOperation(value="返回一个页面的内容")
    @ApiImplicitParam(value = "页面ID")
    @GetMapping("/{id}/get")
    public HttpResponse showPage(@PathVariable("id") Long id){
        return HttpResponseUtil.success(id);
    }
}
