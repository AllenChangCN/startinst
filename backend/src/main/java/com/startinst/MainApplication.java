package com.startinst;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author liuyuancheng
 */
@SpringBootApplication
@MapperScan("com.startinst.dao.mapper")
public class MainApplication {

	public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

	}
}
