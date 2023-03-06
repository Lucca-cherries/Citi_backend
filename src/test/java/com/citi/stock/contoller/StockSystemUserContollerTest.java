package com.citi.stock.contoller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author li
 * @description
 * @createDate 2023/3/5
 */

@SpringBootTest
@AutoConfigureMockMvc
public class StockSystemUserContollerTest {
    private WebApplicationContext wctx;//获取SpringMvc容器
    @Autowired
    MockMvc mm;//用于web独立测试，相当于服务器

    @Test
    public void register() throws Exception {
        ResultActions action = mm.perform(MockMvcRequestBuilders.post("/users/register?stocksystemuserName=u03&stocksystemuserPasword=333"));//通过MockMvc进行http请求测试
        MvcResult resul = action.andReturn();//获取请求结果
        System.out.println(resul.getResponse().getContentAsString());//打印结果
    }

    @Test
    public void login() throws Exception {
        ResultActions action = mm.perform(MockMvcRequestBuilders.get("/users/login?name=u03&pwd=333"));//通过MockMvc进行http请求测试
        MvcResult resul = action.andReturn();//获取请求结果
        System.out.println(resul.getResponse().getContentAsString());//打印结果
    }
    @Test
    public void changePassword ()throws Exception{
        ResultActions action = mm.perform(MockMvcRequestBuilders.put("/users/change_pwd?uid=7&oldPwd=222&newPwd=1111"));//通过MockMvc进行http请求测试
        MvcResult resul = action.andReturn();//获取请求结果
        System.out.println(resul.getResponse().getContentAsString());//打印结果
    }

    @Test
    public void changeInfo ()throws Exception{
        ResultActions action = mm.perform(MockMvcRequestBuilders.put("/users/change_info?uid=8&newName=u08"));//通过MockMvc进行http请求测试
        MvcResult resul = action.andReturn();//获取请求结果
        System.out.println(resul.getResponse().getContentAsString());//打印结果
    }

    @Test
    public void deleteUser ()throws Exception{
        ResultActions action = mm.perform(MockMvcRequestBuilders.delete("/users/delete_a_user/2"));//通过MockMvc进行http请求测试
        MvcResult resul = action.andReturn();//获取请求结果
        System.out.println(resul.getResponse().getContentAsString());//打印结果
    }
}
