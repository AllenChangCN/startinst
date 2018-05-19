package com.startinst.dao.mapper;

import com.startinst.dao.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuyuancheng
 */
public interface SysResourceMapper {
    @Select("SELECT * FROM items WHERE id = #{id}")
    List<SysRole> getRoles(@Param("id") Long id);
}
