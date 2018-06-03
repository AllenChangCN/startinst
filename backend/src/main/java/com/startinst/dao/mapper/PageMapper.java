package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface PageMapper
{

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
                    many=@Many(select="com.startinst.dao.mapper.WidgetMapper.findByPageId"))
    })
    Page findByIdWithWidget(@Param("id") Long id);

    /**
     * 根据用户ID获得Page列表
     * @param userId
     * @return
     */
    @Select("SELECT * FROM pages WHERE user_id=#{userId} AND title LIKE #{search} LIMIT 20")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tagList", column = "id",javaType = List.class,
                    many=@Many(select = "com.startinst.dao.mapper.TagMapper.findTagListByPageId", fetchType = FetchType.EAGER))
    })
    List<Page> findPageListByUserIdAndSearch(@Param("userId") Long userId, @Param("search") String search);


    /**
     * 根据用户ID获得Page列表
     * @param userId
     * @return
     */
    @Select("SELECT * FROM pages WHERE user_id=#{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tagList", column = "id",javaType = List.class,
                    many=@Many(select = "com.startinst.dao.mapper.TagMapper.findTagListByPageId", fetchType = FetchType.EAGER))
    })
    List<Page> findPageListByUserId(@Param("userId") Long userId);

    /**
     * 添加新的Page
     * @param page
     * @return
     */
    @Insert("INSERT INTO pages(id,user_id,is_open,title,description,favorite,created_at,updated_at) " +
            "VALUES(#{id},#{userId},#{isOpen},#{title},#{description}, #{favorite},#{createdAt},#{updatedAt})")
    int insert(Page page);

    /**
     * 更新Page数据
     * @param item
     * @return
     */
    @Update("UPDATE pages SET content=#{content},title=#{title},description=#{description},updated_at=#{updatedAt} WHERE id=#{id}")
    int update(Item item);

    /**
     * Page软删除
     * @param id
     * @param deletedAt
     * @return
     */
    @Update("UPDATE pages SET deleted_at=#{deletedAt} WHERE id=#{id} LIMIT 1")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM items WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);
}
