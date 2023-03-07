package com.citi.stock.service;

import com.citi.stock.entity.StockRecordHistory;

import java.util.List;

public interface IStockRecordHistoryService {
    List<StockRecordHistory> getHistotyOfAStock(String stockCode);

    Integer addHistoryRecordsBatch(List<StockRecordHistory> historyList);
}
