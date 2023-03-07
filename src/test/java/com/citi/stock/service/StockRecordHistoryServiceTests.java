package com.citi.stock.service;

import com.citi.stock.entity.StockRecordHistory;
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
public class StockRecordHistoryServiceTests {
    @Autowired
    private IStockRecordHistoryService iStockRecordHistoryService;

    @Test
    public void getiHistotyOfAStock(){
        String stockCode = "AAPL";
        System.err.println(iStockRecordHistoryService.getHistotyOfAStock(stockCode));
    }

    @Test
    public void addHistoryRecordsBatch(){
        List<StockRecordHistory> historyList = new ArrayList<>();
//        historyList.add(new StockRecordHistory("service"));
//        historyList.add(new StockRecordHistory("service"));
//        historyList.add(new StockRecordHistory("service"));
//        historyList.add((new StockRecordHistory(null, "Test", null, null, null, null, null, null )));

        System.err.println(iStockRecordHistoryService.addHistoryRecordsBatch(historyList));
    }
}
