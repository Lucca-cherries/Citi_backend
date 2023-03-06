package com.citi.stock.service;

import com.citi.stock.entity.Stock;
import com.citi.stock.entity.StockRecordHistory;

import java.util.List;

public interface IStockRecordHistoryService {
    List<StockRecordHistory> getiHistotyOfAStock(String stockCode);
}
