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

    public void deleteByPrimaryKey(){

    }

    @Test
    public void insert(){
        Stock stock = Stock.builder()
                .stockCode("111")
                .stockName("111")
                .stockUpdateDate(new Date())
                .build();
        assert stockMapper.insert(stock)==1;
    }

    public void insertSelective(){

    }

    @Test
    public void selectByPrimaryKey(){
        System.err.println(stockMapper.selectByPrimaryKey(1L));
    }

    public void updateByPrimaryKeySelective(){

    }

    public void updateByPrimaryKey(){

    }
}
