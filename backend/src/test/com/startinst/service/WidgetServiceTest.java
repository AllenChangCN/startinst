package com.startinst.service;

import com.startinst.dao.Widget;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.enums.WidgetTypeEnum;
import com.startinst.model.WidgetModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WidgetServiceTest {

    @Autowired
    private WidgetService widgetService;

    @Autowired
    private WidgetMapper widgetMapper;

    private Long testPageId = 999999999999999999L;

    /**
     * 创建或者删除一个Widget
     */
    @Test
    @Transactional
    void createAndEditAndDelete()
    {
        // 创建
        WidgetModel widgetModel = new WidgetModel();
        widgetModel.setCreatedAt(new Date());
        widgetModel.setDescription("test create widget.");
        widgetModel.setPageId(this.testPageId);
        widgetModel.setTitle("test title.");
        widgetModel.setWidgetType(WidgetTypeEnum.NOTE);
        Widget widget = widgetService.create(widgetModel);
        // 编辑
        widgetModel.setTitle("edited_title");
        widgetModel.setId(widget.getId());
        widgetService.editInfo(widgetModel);
        String retStr = widgetMapper.findById(widget.getId()).toString();
        assertTrue("",retStr.indexOf("edited_title") > 0);
        // 删除
        int effect = widgetService.delete(widget.getId());
        assertTrue("",effect > 0);
    }

    /**
     * 修改Widget位置
     */
    @Test
    @Transactional
    void movePos()
    {
        WidgetModel widgetModel= new WidgetModel();
        widgetModel.setUpdatedAt(new Date());
        widgetModel.setId(197350226783109120L);
        widgetModel.setPosX(0);
        widgetModel.setPosY(5);
        System.out.println(widgetService.setPos(widgetModel));
    }
}
