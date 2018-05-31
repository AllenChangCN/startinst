package com.startinst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liuyuancheng
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ,proxyTargetClass = true)
@EnableCaching(mode = AdviceMode.ASPECTJ,proxyTargetClass = true)
@ComponentScan("com.startinst")
@MapperScan("com.startinst.dao.mapper")
public class MainConfig {}
