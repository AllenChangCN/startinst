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

    @Insert("INSERT INTO items(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{itemsex})")
    Item insert(Item item);

    @Update("UPDATE items SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(Item item);
}
