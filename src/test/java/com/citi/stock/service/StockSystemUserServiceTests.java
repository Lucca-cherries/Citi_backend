package com.citi.stock.service;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
                            .stocksystemuserPasword("111")
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
            String name = "u02";
            String pwd = "222";

            StockSystemUser stockSystemUser=stockSystemUserService.login(name,pwd);

            System.out.println("登录成功！" + stockSystemUser);
        } catch (ServiceException e) {
            System.out.println("登录失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void changePassword () {
        try {

            String oldPwd = "1111";
            String newPwd = "222";
            Integer uid=7;
            stockSystemUserService.changePassword(uid,oldPwd,newPwd);

            System.out.println("密码修改成功！");
        } catch (ServiceException e) {
            System.out.println("密码修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changeInfo () {
        try {
            String newName = "u05";
            Integer uid = 7;
            stockSystemUserService.changeInfo(uid,newName);

            System.out.println("用户名修改成功！");
        } catch (ServiceException e) {
            System.out.println("用户名修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void deleteUser(){
        try {
            Integer uid = 7;
            stockSystemUserService.deleteUser(uid);

            System.out.println("用户注销成功成功！");
        } catch (ServiceException e) {
            System.out.println("用户注销失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }


}
