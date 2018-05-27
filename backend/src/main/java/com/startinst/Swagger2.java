package com.startinst;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyuancheng
 */
//@Configuration
//@EnableSwagger2
//public class Swagger2 {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.startinst"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("RESTful APIs")
//                .description("")
//                .termsOfServiceUrl("")
//                .contact("tenstone@foxmail.com")
//                .version("1.0")
//                .build();
//    }
//}