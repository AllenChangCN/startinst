package com.startinst.controller;

import com.alibaba.fastjson.JSON;
import com.startinst.model.TagCreateModel;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class TagControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @BeforeEach // 在测试开始前初始化工作
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    @Transactional
    void create() throws Exception{
        TagCreateModel tagCreateModel = new TagCreateModel();
        tagCreateModel.setName("testTag");
        System.out.println(JSON.toJSONString(tagCreateModel));
        MvcResult result = this.mockMvc.perform(post("/api/tag/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(tagCreateModel))
        )
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }



}