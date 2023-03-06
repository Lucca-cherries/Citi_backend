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
}
