package com.pagepots.controller;

import com.pagepots.domain.HttpResponse;
import com.pagepots.utils.HttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuancheng
 */


@Api(value = "Widget资源API",description = "")
@RestController
@RequestMapping(value = "/api/widgets")
public class WidgetController {

    @ApiOperation(value = "编辑Widget信息")
    @ApiImplicitParam(name = "widget_id", value = "WidgetId", required = true, dataType = "Integer")
    @PostMapping(value = "/{widget_id}")
    public HttpResponse show(@PathVariable("widget_id") Long widgetId){
        return HttpResponseUtil.success(widgetId);
    }


}
