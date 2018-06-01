package com.startinst.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PageControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @BeforeEach // 在测试开始前初始化工作
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void showPageInfo() throws Exception{

        MvcResult result = this.mockMvc.perform(get("/api/page/999999999999999999/info"))
//                .andExpect(status().isOk())
                .andExpect(content().json("{'code':0}"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void showPageItems() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/api/page/999999999999999999/items"))
//                .andExpect(status().isOk())
                .andExpect(content().json("{'code':0}"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void postCreatePage() throws Exception
    {
        String str = "{\"userId\":2323,\"title\":\"34234234\",\"isOpen\":\"1\",\"description\":\"34234234\",\"tagIdList\":[111,333]}";
        MvcResult result = this.mockMvc.perform(post("/api/page/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(str)
        )
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }



}