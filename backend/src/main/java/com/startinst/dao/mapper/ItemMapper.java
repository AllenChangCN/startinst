package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liuyuancheng
 */
public interface ItemMapper {
    @Select("SELECT * FROM users WHERE NAME = #{name}")
    Item findByName(@Param("name") String name);
}
