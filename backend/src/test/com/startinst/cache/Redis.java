package com.startinst.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Redis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    //直接使用redisTemplate存取字符串
    public void setAndGet() {
        redisTemplate.opsForValue().set("test:set", "testValue1");
        assertEquals("testValue1", redisTemplate.opsForValue().get("test:set"));
    }
}
