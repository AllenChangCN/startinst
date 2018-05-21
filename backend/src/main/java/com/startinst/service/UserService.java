package com.startinst.service;

import com.startinst.dao.SysUser;
import com.startinst.dao.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author liuyuancheng
 */
@Service
public class UserService {
    /**
     * 通过名称查找用户
     *
     * @param username
     * @return
     */
    private SysUserMapper sysUserMapper;

    public SysUser findByUsername(String username) {
//        SysUser sysUser = new SysUser();
//        sysUser.setName("系统管理员");
//        sysUser.setPassword("4a496ba2a4172c71540fa643ddc8bb7c");
//        sysUser.setSalt("b4752b4b73034de06afb2db30fe19061");
//        List<SysRole> roles = new ArrayList<>();
//        SysRole role = new SysRole();
//        role.setId(1);
//        role.setRole("admin");
//        role.setDescription("超级管理员");
//        roles.add(role);
//        sysUser.setRoles(roles);
//        return sysUser;
        return sysUserMapper.findUserById(1L);
    }


}
