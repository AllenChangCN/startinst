package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.utils.MybatisRedisCache;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface PageMapper {

    @Select("SELECT * FROM pages WHERE id = #{id}")
    Page findById(@Param("id") Long id);

    /**
     * 获得页面中所有的Widget和Item数据
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM pages WHERE id = #{id} LIMIT 1")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property="widgetList",column="id",javaType=List.class,
                    many=@Many(select="com.startinst.dao.mapper.WidgetMapper.findByPageIdWithItemList"))
    })
    @Options(useCache = true)
    Page findByIdWithWidgetNestData(@Param("id") Long id);

    /**
     * 根据用户ID获得Page列表
     * @param userId
     * @return
     */
    @Select("SELECT * FROM pages WHERE user_id=#{userId}")
    List<Page> findByUserId(@Param("userId") Long userId);

    @Insert("INSERT INTO pages(id,widget_id,title,description,content,created_at,updated_at) " +
            "VALUES(#{id}, #{widgetId},#{title},#{description}, #{content}, #{createdAt},#{updatedAt})")
    int insert(Page page);

    @Update("UPDATE pages SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id=#{id}")
    int update(Item item);

    @Update("UPDATE pages SET deleted_at=#{deletedAt} WHERE id=#{id} LIMIT 1")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    @Delete("DELETE FROM items WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);
}
