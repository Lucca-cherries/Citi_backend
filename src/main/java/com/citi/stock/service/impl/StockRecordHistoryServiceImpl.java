package com.citi.stock.service.impl;

import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.mapper.StockRecordHistoryMapper;
import com.citi.stock.service.IStockRecordHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StockRecordHistoryServiceImpl implements IStockRecordHistoryService {
    @Resource
    private StockRecordHistoryMapper stockRecordHistoryMapper;

    @Override
    public List<StockRecordHistory> getHistotyOfAStock(String stockCode) {
        log.debug("Service: Getting history for {}", stockCode);
        List<StockRecordHistory> historyList =
                stockRecordHistoryMapper.selectByStockCode(stockCode);
        log.debug("Service: Length of stock history: {}", historyList.size());
        return historyList;
    }

    @Override
    public Integer addHistoryRecordsBatch(List<StockRecordHistory> historyList) {
        log.debug("Service: Adding history records in batch for with first record: {}", historyList.get(0));
        return stockRecordHistoryMapper.insertBatch(historyList);
    }

    @Override
    public Integer insertOne(StockRecordHistory stockRecordHistory) {
        log.debug("Service: Insert one history record: {}", stockRecordHistory);
        return stockRecordHistoryMapper.insert(stockRecordHistory);
    }
}
