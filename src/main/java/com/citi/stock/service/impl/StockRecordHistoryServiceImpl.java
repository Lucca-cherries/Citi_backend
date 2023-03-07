package com.citi.stock.service.impl;

import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.mapper.StockRecordHistoryMapper;
import com.citi.stock.service.IStockRecordHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRecordHistoryServiceImpl implements IStockRecordHistoryService {
    @Autowired
    private StockRecordHistoryMapper stockRecordHistoryMapper;

    @Override
    public List<StockRecordHistory> getHistotyOfAStock(String stockCode) {
        List<StockRecordHistory> historyList =
                stockRecordHistoryMapper.selectByStockCode(stockCode);
        System.err.println("Length of stock histoty:" + historyList.size());
        return historyList;
    }

    @Override
    public Integer addHistoryRecordsBatch(List<StockRecordHistory> historyList) {
        return stockRecordHistoryMapper.insertBatch(historyList);
    }
}
