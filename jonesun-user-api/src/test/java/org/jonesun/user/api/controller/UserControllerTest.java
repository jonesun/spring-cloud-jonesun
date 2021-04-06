package org.jonesun.user.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jonesun.user.api.entity.UserForm;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jone.sun
 * 2021/4/1 16:50
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("用户Controller层测试")
@AutoConfigureMockMvc //不启动服务器,使用mockMvc进行测试http请求
@SpringBootTest
class UserControllerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Autowired
    public UserControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Order(1)
    @DisplayName("注册")
    @Test
    void register() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setName("jonesun");
        userForm.setAge(30);
        userForm.setEmail("sunr922@163.com");
        //请求路径不要错了
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        //这里要特别注意和content传参数的不同，具体看你接口接受的是哪种
//                        .param("userName",info.getUserName()).param("password",info.getPassword())
                        //传json参数,最后传的形式是 Body = {"password":"admin","userName":"admin"}
                        .content(objectMapper.writeValueAsString(userForm))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();

        logger.info("status: {}, content: {}", status, content);
    }

    @Order(2)
    @DisplayName("列表")
    @Test
    void list() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/api/users")
//                .param("searchPhrase","ABC")          //传参
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);  //请求类型 JSON
        MvcResult mvcResult = mockMvc.perform(request)
                // 期望的结果状态 等同于Assert.assertEquals(200,status);
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())                 //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn();                                         //返回验证成功后的MvcResult；用于自定义验证/下一步的异步处理；
        int status = mvcResult.getResponse().getStatus();                 //得到返回代码
        String content = mvcResult.getResponse().getContentAsString();    //得到返回结果
        logger.info("status: {}, content: {}", status, content);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")));
    }
}