package com.citi.stock.service;

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
public class StockRecordHistoryServiceTests {
    @Autowired
    private IStockRecordHistoryService iStockRecordHistoryService;

    @Test
    public void getiHistotyOfAStock(){
        String stockCode = "AAPL";
        System.err.println(iStockRecordHistoryService.getiHistotyOfAStock(stockCode));
    }
}
