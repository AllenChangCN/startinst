package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public interface ItemMapper {

    @Select("SELECT * FROM items WHERE widget_id = #{widgetId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property="widget",column="widget_id",javaType=Widget.class,
                    one=@One(select="com.startinst.dao.mapper.WidgetMapper.findById"))
    })
    List<Item> findByWidgetId(@Param("widgetId") Long widgetId);

    @Select("SELECT * FROM items WHERE id = #{id}")
    Item findById(@Param("id") Long id);

    @Insert("INSERT INTO items(id,widget_id,title,item_type,description,content,created_at) " +
            "VALUES(#{id}, #{widgetId},#{title},#{itemType},#{description}, #{content}, #{createdAt})")
    int insert(Item item);

    @Update("UPDATE items SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id =#{id}")
    int updateContent(Item item);

    @Update("UPDATE items SET deleted_at=#{deletedAt}")
    int softDelete(@Param(value = "id") Long id, @Param(value = "deletedAt") Date deletedAt);

    @Delete("DELETE FROM items WHERE id=#{id}")
    int deleteById(Long id);

    @Delete("DELETE FROM items WHERE widget_id=#{widgetId}")
    int deleteItemByWidgetId(@Param(value ="widgetId") Long widgetId);

    @Update("UPDATE items SET deleted_at=#{deletedAt} WHERE widgetId=#{widgetId}")
    int softDeleteItemByWidgetId(@Param(value ="widgetId") Long widgetId,@Param(value = "deletedAt") Date deletedAt);
}
