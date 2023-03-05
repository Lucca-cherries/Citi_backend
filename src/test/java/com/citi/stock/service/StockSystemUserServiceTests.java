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
//            StockSystemUser stockSystemUser=new StockSystemUser();
//            stockSystemUser.setStocksystemuserName("u01");
//            stockSystemUser.setStocksystemuserPasword("111");
//            stockSystemUserService.register(stockSystemUser);
//            System.out.println("注册成功！");
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


}
