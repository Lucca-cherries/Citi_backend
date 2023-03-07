package com.citi.stock.mapper;

import com.citi.stock.entity.StockRecordHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StockRecordHistoryMapperTests {
    @Autowired
    private StockRecordHistoryMapper stockRecordHistoryMapper;

    @Test
    public void selectByStockCode(){
        String code = "AAPL";
        System.err.println(stockRecordHistoryMapper.selectByStockCode(code));
    }

    @Test
    public void insertBatch(){
        List<StockRecordHistory> historyList = new ArrayList<>();
        historyList.add(new StockRecordHistory("test"));
        historyList.add(new StockRecordHistory("test"));
        historyList.add(new StockRecordHistory("test"));

        System.err.println(stockRecordHistoryMapper.insertBatch(historyList));
    }
}
