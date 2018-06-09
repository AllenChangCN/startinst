package com.startinst.controller;

import com.startinst.model.HttpResponse;
import com.startinst.model.WidgetModel;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuancheng
 */


@RestController
@RequestMapping(value = "/api/widgets")
public class WidgetController {

    /**
     * 创建一个Widget
     * @param widgetModel
     * @return
     */
    @PostMapping(value = "create")
    public HttpResponse create(@RequestBody WidgetModel widgetModel)
    {
        return HttpResponseUtil.success();
    }

    /**
     * 删除Widget
     * @param widgetId
     * @return
     */
    @PostMapping(value = "{widget_id}/delete")
    public HttpResponse delete(@PathVariable("widget_id") Long widgetId)
    {
        return HttpResponseUtil.success(widgetId);
    }

    /**
     * 编辑Widget
     * @param widgetId
     * @param widgetModel
     * @return
     */
    @PostMapping(value = "{widget_id}/edit")
    public HttpResponse edit(@PathVariable("widget_id") Long widgetId, @RequestBody WidgetModel widgetModel)
    {
        return HttpResponseUtil.success();
    }

}
