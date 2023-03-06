package com.citi.stock.controller;

import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.service.IStockRecordHistoryService;
import com.citi.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/stockhistories")
@RestController
public class StockRecordHistoryController {
    @Autowired
    private IStockRecordHistoryService iStockRecordHistoryService;

    @GetMapping("/{stockCode}")
    public List<StockRecordHistory> getHistoryOfAStock(
            @PathVariable("stockCode") String stockCode){
//        System.err.println(stockCode);
        List<StockRecordHistory> historyList =
                iStockRecordHistoryService.getiHistotyOfAStock(stockCode);
//        System.err.println(historyList);
        return historyList;
    }
}
