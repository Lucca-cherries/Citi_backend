package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class StockMapperTests {
    @Autowired
    private StockMapper stockMapper;

    @Test
    public void getTotalNum(){
        System.err.println(stockMapper.getTotalNum());
    }

    @Test
    public void selectByPage(){
        System.err.println(stockMapper.selectByPage(10, 10));
    }

    @Test
    public void selectStockVOByPage(){
        System.err.println(stockMapper.selectStockVOByPage(2, 1, 5));
    }

    @Test
    public void selectStockVOByCode(){
        System.err.println(stockMapper.selectStockVOByCode(16, "AAPL"));
    }

    @Test
    public void conditionSelectStockVOByPage(){
        System.err.println(
                stockMapper.conditionSelectStockVOByPage(1, 0, 5, "", "a"));
    }

    @Test
    public void getTotalConditionNum(){
        System.err.println(stockMapper.getTotalConditionNum("", "a"));
    }
}
