package com.startinst;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuyuancheng
 */
@SpringBootApplication
public class MainApplication
{

	public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);

	}
}
