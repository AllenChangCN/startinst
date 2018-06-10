package com.startinst.service;

import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.WidgetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class WidgetService {

    @Autowired
    WidgetMapper widgetMapper;

    @Autowired
    ItemMapper itemMapper;

    /**
     * 创建Widget
     * @param widgetModel
     * @return
     */
    public Widget create(WidgetModel widgetModel)
    {
        Widget widget = new Widget();
        widget.setId();
        widget.setWidgetType(widgetModel.getWidgetType());
        widget.setCreatedAt(new Date());
        widget.setPageId(widgetModel.getPageId());
        widget.setTitle(widgetModel.getTitle());
        widget.setPosX(3);
        widget.setPosY(widgetMapper.getMaxPosY(widgetModel.getPageId(),3) + 1);
        widget.setPageId(widgetModel.getPageId());
        widget.setDescription(widgetModel.getDescription());
        int effect = widgetMapper.insert(widget);
        return effect > 0 ? widget : null;
    }

    /**
     * 编辑Widget
     * @param widgetModel
     * @throws
     * @return
     */
    public Widget edit(WidgetModel widgetModel) throws RuntimeException
    {
        Widget widget = widgetMapper.findById(widgetModel.getId());
        if(widget == null){
            throw new RuntimeException("Widget Not Found.");
        }
        widget.setWidgetType(widgetModel.getWidgetType());
        widget.setCreatedAt(new Date());
        widget.setTitle(widgetModel.getTitle());
        widget.setDescription(widgetModel.getDescription());
        widget.setUpdatedAt(new Date());
        int effect = widgetMapper.update(widget);
        return effect > 0 ? widget : null;
    }

    /**
     * 删除Widget
     * @param widgetId
     * @return
     */
    public int delete(Long widgetId)
    {
        return widgetMapper.delete(widgetId);
    }

    /**
     * 移动Widget的位置
     *
     * @param originWidget
     * @param targetWdiget
     * @return
     */
    public String move(Widget originWidget,Widget targetWdiget)
    {
        return "";
    }
}
