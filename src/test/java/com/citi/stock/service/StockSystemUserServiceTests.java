package com.citi.stock.service;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author li
 * @description
 * @createDate 2023-3-4
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockSystemUserServiceTests {
    @Autowired
    private IStockSystemUserService stockSystemUserService;
    @Test
    public void register() {
        try {

            StockSystemUser stockSystemUser= StockSystemUser.builder()
                    .stocksystemuserName("u01")
                    .stocksystemuserPassword("111")
                    .build();


            stockSystemUserService.register(stockSystemUser);
            System.out.println("注册成功！");


        } catch (ServiceException e) {
            System.out.println("注册失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void login() {
        try {
            String name = "u03";
            String pwd = "333";

            StockSystemUser stockSystemUser=stockSystemUserService.login(name,pwd);

            System.out.println("登录成功！" + stockSystemUser);
        } catch (ServiceException e) {
            System.out.println("登录失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteUser(){
        try {
            String username = "u01";
            stockSystemUserService.deleteUser(1, username);

            System.out.println("用户注销成功成功！");
        } catch (ServiceException e) {
            System.out.println("用户注销失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void changePwd(){
        try {


            stockSystemUserService.changePwd("u03@qq.com","333","222");

            System.out.println("密码修改成功！");
        } catch (ServiceException e) {
            System.out.println("密码修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
