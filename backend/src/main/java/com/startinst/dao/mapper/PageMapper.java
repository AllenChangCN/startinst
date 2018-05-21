package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public interface PageMapper {
    @Select("SELECT * FROM items WHERE widget_id = #{widget_id}")
    // 多对多
    List<Widget> findByWidgetId(@Param("widgetId") Long widgetId);

    @Select("SELECT * FROM items WHERE id = #{id}")
    Widget findOne(@Param("id") Long id);

    @Insert("INSERT INTO items(id,widget_id,title,description,content,created_at,updated_at) " +
            "VALUES(#{id}, #{widgetId},#{title},#{description}, #{content}, #{createdAt},#{updatedAt})")
    int insert(Item item);

    @Update("UPDATE items SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id =#{id}")
    int updateContent(Item item);

    @Update("UPDATE items SET deleted_at=#{deletedAt}")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    @Delete("DELETE FROM items WHERE id=#{id}")
    int delete(@Param("id") Long id);
}
