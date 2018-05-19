package com.startinst.dao.mapper;

import com.startinst.dao.SysPermission;
import com.startinst.dao.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuyuancheng
 */
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole findRoleById(@Param("id") Long id);

    @Select("SELECT * FROM sys_permission JOIN sys_role_permission ON sys_role_permission.permission.id=permission.id" +
            "WHERE sys_permission.id=#{id}")
    List<SysPermission> findPermissionsByRoleId(@Param("id") Long id);
}
