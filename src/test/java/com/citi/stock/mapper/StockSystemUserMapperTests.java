package com.citi.stock.mapper;

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
        System.err.println(stockSystemUserMapper.findByUserName("u03"));
        assert stockSystemUserMapper.findByUserName("u03").getStocksystemuserPassword().equals("333");
    }

    @Test
    public void deleteByUsername(){
        System.err.println(stockSystemUserMapper.deleteByUsername("jgq"));
    }
}
