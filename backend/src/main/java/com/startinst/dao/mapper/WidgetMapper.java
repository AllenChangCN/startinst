package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.Widget;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public interface WidgetMapper {

    /**
     * 根据WidgetId查询Widget
     * @param id
     * @return
     */
    @Select("SELECT * FROM widgets WHERE id = #{id}")
    @Results({
        @Result(property="itemList",column="id",javaType=List.class,
                many=@Many(select="com.startinst.dao.mapper.ItemMapper.findByWidgetId")),
    })
    Widget findById(@Param("id") Long id);

    /**
     * 根据页面Id获得Widget List
     * @param pageId
     * @return
     */
    @Select("SELECT * FROM widgets WHERE page_id=#{pageId}")
    @Results({
        @Result(property="page",column="page_id",javaType=Page.class,
                one=@One(select="com.startinst.dao.mapper.PageMapper.findById"))
    })
    List<Widget> findByPageId(@Param("pageId") Long pageId);

    /**
     * 插入一个Widget
     * @param widget
     * @return
     */
    @Insert("INSERT INTO widgets(id,page_id,widget_type,title,description,created_at) " +
            "VALUES(#{id},#{pageId},#{widgetType},#{title},#{description}, #{createdAt})")
    int insert(Widget widget);

    @Update("UPDATE items SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id =#{id}")
    int updateContent(Widget widget);

    @Update("UPDATE items SET deleted_at=#{deletedAt} WHERE id=#{id} LIMIT 1;")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    @Delete("DELETE FROM items WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);
}
