package com.citi.stock.mapper;

import com.citi.stock.entity.StockRecordHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockRecordHistoryMapperTests {
    @Autowired
    private StockRecordHistoryMapper stockRecordHistoryMapper;

    @Test
    public void selectByStockCode(){
        String code = "AAPL";
        System.err.println(stockRecordHistoryMapper.selectByStockCode(code));
    }
}
