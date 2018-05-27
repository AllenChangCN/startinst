package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuancheng
 */


@RestController
@RequestMapping(value = "/api/widgets")
public class WidgetController {

    @PostMapping(value = "/{widget_id}")
    public HttpResponse show(@PathVariable("widget_id") Long widgetId){
        return HttpResponseUtil.success(widgetId);
    }


}
