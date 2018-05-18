package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author liuyuancheng
 */
public interface WidgetMapper {
    @Select("SELECT * FROM items WHERE widget_id = #{widget_id}")
    List<Item> findByWidgetId(@Param("widget_id") Long widgetId);

    @Select("SELECT * FROM items WHERE id = #{id}")
    Item findOne(@Param("id") Long id);

    @Insert("INSERT INTO items(id,widget_id,title,description,content,created_at,updated_at) " +
            "VALUES(#{id}, #{widgetId},#{title},#{description}, #{content}, #{createdAt},#{updatedAt})")
    int insert(Item item);

    @Update("UPDATE items SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id =#{id}")
    int updateContent(Item item);

    @Update("Update items SET deleted=1")
    int delete(Long id);

    @Delete("DELETE FROM items WHERE id=#{id}")
    int forceDelete(Long id);
}
