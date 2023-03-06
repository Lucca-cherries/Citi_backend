package com.citi.stock.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @description
 * @createDate 2023-3-4
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTests {
    @Autowired
    private IStockService iStockService;

    @Test
    public void selectByPage(){
        System.err.println(iStockService.getByPage(1, 10));
    }

    @Test
    public void selectStockVOByPage() {
        System.err.println(iStockService.getStockVOByPage(1, 1*2, 2));
    }

    @Test
    public void getTotalNumOfStocks(){
        System.err.println(iStockService.getTotalNumOfStocks());
    }

    @Test
    public void getStockLastestVO(){
        List<String> stockCodes = new ArrayList<>();
        stockCodes.add("AAPL");
        stockCodes.add("MSFT");
        stockCodes.add("GOOG");
        System.err.println(iStockService.getFinnhub(stockCodes));
    }
}
