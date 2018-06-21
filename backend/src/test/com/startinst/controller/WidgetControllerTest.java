package com.startinst.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class WidgetControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @BeforeEach // 在测试开始前初始化工作
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    @Transactional
    void edit() throws Exception{

        MvcResult result = this.mockMvc.perform(get("/api/widgets/999999999999999999/edit"))
                .andExpect(status().isOk())
//                .andExpect(content().json("{'code':0}"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}