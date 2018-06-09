package com.startinst.dao.mapper;

import com.startinst.dao.Widget;
import com.startinst.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface WidgetMapper {

    /**
     * 根据WidgetId查询Widget
     * @param id
     * @return
     */
    @Select("SELECT * FROM widgets WHERE id = #{id} AND deleted_at IS NULL LIMIT 1")
    Widget findById(@Param("id") Long id);

    /**
     * 根据WidgetId查询Widget
     * @param id
     * @return
     */
    @Select("SELECT * FROM widgets WHERE id = #{id} AND deleted_at IS NULL LIMIT 1")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property="itemList",column="id",javaType=List.class,
                    many=@Many(select="com.startinst.dao.mapper.ItemMapper.findByWidgetId")),
    })
    Widget findByIdWithItemList(@Param("id") Long id);

    /**
     * 获取页面中Widget的Id 列表
     *
     * @param pageId
     * @return
     */
    @Select("SELECT id FROM widgets WHERE page_id=#{pageId} ORDER BY posY ASC,posX ASC")
    List<Long> findWidgetIdListByPageId(@Param("pageId") Long pageId);

    /**
     * 根据页面Id获得Widget List，包含Item List数据
     * @param pageId
     * @return
     */
    @Select("SELECT * FROM widgets WHERE page_id=#{pageId} AND deleted_at IS NULL LIMIT 400")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "pageId",column = "page_id"),
            @Result(property="itemList",column="id",javaType=List.class,
                    many=@Many(select="com.startinst.dao.mapper.ItemMapper.findByWidgetId")),
    })
    List<Widget> findByPageIdWithItemList(@Param("pageId") Long pageId);

    /**
     * 获取不包含Item数据的Widget列表
     * @param pageId
     * @return
     */
    @Select("SELECT * FROM widgets WHERE page_id=#{pageId} AND deleted_at IS NULL LIMIT 400")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "pageId",column = "page_id"),
    })
    List<Widget> findByPageId(@Param("pageId") Long pageId);

    /**
     * 插入一条
     * @param widget
     * @return
     */
    @Insert("INSERT INTO widgets(id,page_id,widget_type,title,description,created_at,pos_x,pos_y) " +
            "VALUES(#{id},#{pageId},#{widgetType},#{title},#{description}, #{createdAt},#{posX},#{posY})")
    int insert(Widget widget);

    /**
     * 更新基本信息
     *
     * @param widget
     * @return
     */
    @Update("UPDATE widgets SET title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id=#{id} LIMIT 1")
    int update(Widget widget);

    /**
     * 软删除
     *
     * @param id
     * @param deletedAt
     * @return
     */
    @Update("UPDATE widgets SET deleted_at=#{deletedAt} WHERE id=#{id} LIMIT 1")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    /**
     * 彻底删除一条数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM widgets WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);

    /**
     * 更新Widget位置
     *
     * @param id
     * @param posX
     * @param posY
     * @return
     */
    @Update("UPDATE widgets SET pos_x=#{posX},pos_y=#{posY} WHERE id=#{id} LIMIT 1")
    int updateWidgetPosById(@Param("id") Long id,@Param("posX") Integer posX, @Param("posY") Integer posY);

    /**
     * 获取Widget的PosY最大值
     * @param id
     * @param posX
     * @return
     */
    @Select("SELECT MAX(pos_y) FROM widgets WHERE page_id=#{pageId} AND pos_x=#{posX}")
    int getMaxPosY(@Param("pageId") Long id,@Param("posX") Integer posX);

    /**
     * 更新widget 的Size
     * @param widgetId
     * @return
     */
    @Update("UPDATE widgets SET size=(SELECT COUNT(id) FROM items WHERE widget_id=#{widgetId} AND deleted_at IS NULL) WHERE id=#{widgetId} LIMIT 1")
    int updateWidgetSize(@Param("widgetId") Long widgetId);
}
