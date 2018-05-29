package com.startinst.dao.mapper;

import com.startinst.cache.MybatisRedisCache;
import com.startinst.dao.Item;
import com.startinst.dao.Page;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface TagMapper {

    /**
     * 添加新的Page
     * @param page
     * @return
     */
    @Insert("INSERT INTO pages(id,widget_id,title,description,content,created_at,updated_at) " +
            "VALUES(#{id}, #{widgetId},#{title},#{description}, #{content}, #{createdAt},#{updatedAt})")
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
    @Delete("DELETE FROM tags WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);
}
