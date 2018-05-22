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
            @Result(property = "id",column = "id"),
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
            @Result(property = "id",column = "id"),
            @Result(property = "pageId",column = "page_id"),
            @Result(property="itemList",column="id",javaType=List.class,
                    many=@Many(select="com.startinst.dao.mapper.ItemMapper.findByWidgetId")),
            @Result(property="page",column="page_id",javaType=Page.class,
                    one=@One(select="com.startinst.dao.mapper.PageMapper.findById"))
    })
    List<Widget> findByPageId(@Param("pageId") Long pageId);

    /**
     * 插入一条
     * @param widget
     * @return
     */
    @Insert("INSERT INTO widgets(id,page_id,widget_type,title,description,created_at) " +
            "VALUES(#{id},#{pageId},#{widgetType},#{title},#{description}, #{createdAt})")
    int insert(Widget widget);

    /**
     * 更新基本信息
     *
     * @param widget
     * @return
     */
    @Update("UPDATE widgets SET title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id=#{id} LIMIT 1")
    int updateInfo(Widget widget);

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
}
