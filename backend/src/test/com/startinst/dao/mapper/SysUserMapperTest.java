package com.startinst.dao.mapper;

import com.startinst.dao.SysRole;
import com.startinst.dao.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class SysUserMapperTest {

    Long testId = 999999999999999999L;

    @Autowired(required = true)
    private SysUserMapper sysUserMapper;

    @Test
    void findUserById(){
        SysUser sysUser = sysUserMapper.findUserById(1L);
        System.out.println(sysUser);
    }

    @Test
    void findRolesById() {
        List<SysRole> roles = sysUserMapper.findRolesByUserId(1L);
        System.out.println(roles);
    }



}