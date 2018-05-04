package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuancheng
 */
@Api(value = "页面跳转")
@Controller
@RequestMapping(value = "/link-jump")
public class LinkJumpController {

    @ApiOperation(value = "跳转到制定页面，并提交参数用户统计",notes = "因数据分析需要，统计访问量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page_id",required = true,dataType = "Long")
    })
    @GetMapping(value = "from/{page_id}/target/{target_url}")
    public HttpResponse info(@PathVariable("page_id") Long pageId,
                             @PathVariable("target_url") String targetUrl){
        return HttpResponseUtil.success();
    }

}
