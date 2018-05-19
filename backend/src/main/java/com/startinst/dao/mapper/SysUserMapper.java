package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.SysRole;
import com.startinst.dao.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
public interface SysUserMapper {
    @Select("SELECT * FROM sys_role JOIN sys_user_role ON sys_user_role.role_id=sys_role.id " +
            "JOIN sys_user ON sys_user_role.user_id=sys_user.id " +
            "WHERE sys_user.id = #{id}")
    List<SysRole> findRolesByUserId(@Param("id") Long id);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser findUserById(@Param("id") Long id);
}
