package com.citi.stock.mapper;

import com.citi.stock.entity.StockSystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author li
 * @description
 * @createDate 2023/3/4
 */
@SpringBootTest
public class StockSystemUserMapperTests {
    @Autowired
    private StockSystemUserMapper stockSystemUserMapper;

    @Test
    public void findByUserName(){
        System.err.println(stockSystemUserMapper.findByUserName("u01"));
        assert stockSystemUserMapper.findByUserName("u01").getStocksystemuserPassword().equals("111");
    }

    @Test
    public void deleteByUsername(){
        System.err.println(stockSystemUserMapper.deleteByUsername("jgq"));
    }

    @Test
    public void change(){
        StockSystemUser stockSystemUser= StockSystemUser.builder()
                .stocksystemuserName("u03@qq.com")
                .stocksystemuserPassword("222")
                .stocksystemuserId(5)
                .build();
        System.err.println(stockSystemUserMapper.updateByPrimaryKey(stockSystemUser));
    }
}
