package com.startinst;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author liuyuancheng
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.startinst.dao.mapper")
public class MainApplication {


	public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);


	}
}
