package com.startinst.dao.mapper;

import com.startinst.dao.Item;
import com.startinst.dao.SysUser;
import com.startinst.enums.ItemTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserMapperTest {

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