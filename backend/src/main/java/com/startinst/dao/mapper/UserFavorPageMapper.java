package com.startinst.dao.mapper;

import com.startinst.cache.MybatisRedisCache;
import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.UserFavorPage;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface UserFavorPageMapper {

    /**
     * 根据用户ID获取用户收藏的页面ID
     * @param userId
     * @return
     */
    @Select("SELECT page_id,created_at FROM page_user_favor where user_id=#{userId}")
    @Results({
            @Result(property = "page",column = "page_id",javaType = Page.class,
                    one = @One(select = "com.startinst.dao.mapper.PageMapper.findById"))
    })
    List<UserFavorPage> findUserFavorPageByUserId(@Param("userId") Long userId);

    /**
     * 添加新的Page
     * @param userFavorPage
     * @return
     */
    @Insert("INSERT INTO page_user_favor(page_id,user_id,created_at) " +
            "VALUES(#{pageId},#{userId},#{createdAt})")
    int insert(UserFavorPage userFavorPage);

    /**
     * 删除一条数据
     * @param userId
     * @param pageId
     * @return
     */
    @Delete("DELETE FROM page_user_favor WHERE user_id=#{userId} AND page_id=#{pageId} LIMIT 1")
    int delete(@Param("userId") Long userId,@Param("pageId") Long pageId);
}
