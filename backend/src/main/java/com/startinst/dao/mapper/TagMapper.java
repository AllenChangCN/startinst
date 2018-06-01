package com.startinst.dao.mapper;

import com.startinst.cache.MybatisRedisCache;
import com.startinst.dao.Item;
import com.startinst.dao.Tag;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface TagMapper {

    /**
     * 查看tag
     * @param id
     * @return
     */
    @Select("SELECT * FROM tags WHERE id=#{id} LIMIT 1")
    Tag findById(Long id);

    /**
     * 根据pageId获取Tag列表
     * @param id
     * @return
     */
    @Select("SELECT * FROM tags WHERE id IN (SELECT tag_id FROM page_tag WHERE page_id=#{id})")
    List<Tag> findTagListByPageId(Long id);

    /**
     * tag useCount递增1
     * @param id
     * @return
     */
    @Update("UPDATE tags SET use_count = (SELECT COUNT(id) from page_tag WHERE tag_id=#{id}) WHERE id=#{id}")
    int refreshUseCount(Long id);

    /**
     * 添加新的Tag
     * @param tag
     * @return
     */
    @Insert("INSERT INTO tags(id,type,name,created_at) VALUES(#{id},#{type},#{name},#{createdAt})")
    int insert(Tag tag);

    /**
     * 更新Tag数据
     * @param tag
     * @return
     */
    @Update("UPDATE tags SET name=#{name} WHERE id=#{id}")
    int update(Tag tag);

    /**
     * 更新tag使用量
     * @param tagId
     * @return
     */
    @Update("UPDATE tags SET use_count=(SELECT COUNT(id) FROM page_tag WHERE tag_id=#{tagId}) LIMIT 1")
    int updateUseCount(Long tagId);

    /**
     * Tag软删除
     * @param id
     * @param deletedAt
     * @return
     */
    @Update("UPDATE tags SET deleted_at=#{deletedAt} WHERE id=#{id} LIMIT 1")
    int softDelete(@Param("id") Long id, @Param("deletedAt") Date deletedAt);

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM tags WHERE id=#{id} LIMIT 1")
    int delete(@Param("id") Long id);
}
