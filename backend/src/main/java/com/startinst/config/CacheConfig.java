package com.startinst.config;

import com.startinst.dao.Page;
import com.startinst.dao.SysUser;
import com.startinst.utils.RedisSerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@EnableCaching //开启缓存支持
class CacheConfig extends CachingConfigurerSupport{

    @Bean
    LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory);
        return  redisCacheManager;
    }

    @Bean
    @Autowired
    public RedisTemplate<String, Page> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Page> template = new RedisTemplate<String, Page>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisSerializeUtil());
        return template;
    }
}