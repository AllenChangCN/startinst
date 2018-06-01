package com.startinst;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
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
public class MainConfig {
    @Bean
    public ObjectMapper ObjectMapper()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        // 配置，对象序列化时，所有的Long转换为String
        objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS,true);
        return objectMapper;
    }
}
