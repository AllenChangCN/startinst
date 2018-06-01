package com.startinst.dao.mapper;

import com.startinst.cache.MybatisRedisCache;
import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.PageTag;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface PageTagMapper {

    @Select("SELECT * FROM page_tag WHERE page_id=#{pageId}")
    List<PageTag> findByPageId(Long pageId);

    /**
     * 添加新的Page
     * @param pageTag
     * @return
     */
    @Insert("INSERT INTO page_tag(page_id,tag_id,created_at) " +
            "VALUES(#{pageId},#{tagId}, #{createdAt})")
    int insert(PageTag pageTag);

    /**
     * 删除一条数据
     * @param pageId
     * @return
     */
    @Delete("DELETE FROM page_tag WHERE page_id=#{pageId} LIMIT 1")
    int delete(@Param("pageId") Long pageId);
}
