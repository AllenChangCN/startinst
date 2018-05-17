package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author liuyuancheng
 */
public interface ItemMapper {
    @Select("SELECT * FROM items WHERE widget_id = #{widget_id}")
    Item findByWidgetId(@Param("widget_id") Long widgetId);

    @Select("SELECT * FROM items WHERE id = #{id}")
    Item findOne(@Param("id") Long id);

    @Insert("INSERT INTO items(id,widget_id,content,created_at,updated_at) " +
            "VALUES(#{id}, #{widgetId}, #{content}, #{createdAt},#{updatedAt})")
    void insert(Item item);

    @Update("UPDATE items SET content=#{content},item_type=#{itemType} WHERE id =#{id}")
    void update(Item item);
}
