package com.startinst.dao.mapper;

import com.startinst.dao.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SysRoleMapperTest {

    Long testId = 999999999999999999L;

    @Autowired(required = true)
    private SysUserMapper sysUserMapper;

    @Test
    public void findUserById(){
        SysUser sysUser = sysUserMapper.findUserById(1L);
        System.out.println(sysUser);
    }

    @Test
    public void getRoles() {
        SysUser sysUser = sysUserMapper.findUserById(1L);
//        sysUserMapper.getRoles();
    }



}