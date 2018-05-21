package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public interface WidgetMapper {

    @Select("SELECT * FROM widgets WHERE id = #{id}")
    Widget findOne(@Param("id") Long id);

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
