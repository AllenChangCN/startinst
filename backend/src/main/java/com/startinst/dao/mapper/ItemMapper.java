package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Widget;
import com.startinst.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface ItemMapper {

    /**
     * 通过Widget Id获得items
     * @param widgetId
     * @return
     */
    @Select("SELECT * FROM items WHERE widget_id = #{widgetId}")
    List<Item> findByWidgetId(@Param("widgetId") Long widgetId);

    /**
     * 通过page id获得Item
     *
     * @param pageId
     * @return
     */
    @Select("SELECT * FROM items WHERE page_id = #{pageId}")
    List<Item> findByPageId(@Param("pageId") Long pageId);

    /**
     * 获取Item信息，要带Widget信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM items WHERE id = #{id}")
    Item findById(@Param("id") Long id);

    /**
     * 插入一条数据
     * @param item
     * @return
     */
    @Insert("INSERT INTO items(id,widget_id,page_id,title,item_type,description,content,created_at) " +
            "VALUES(#{id}, #{widgetId},#{pageId},#{title},#{itemType},#{description}, #{content}, #{createdAt})")
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
