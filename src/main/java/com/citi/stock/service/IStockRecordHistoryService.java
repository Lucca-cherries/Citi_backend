package com.citi.stock.service;

import com.citi.stock.entity.StockRecordHistory;

import java.util.List;

public interface IStockRecordHistoryService {
    /**
     * 获取一只股票的历史记录，用于详细面板的K线图展示
     * @param stockCode 股票symbol
     * @return 历史记录列表
     */
    List<StockRecordHistory> getHistotyOfAStock(String stockCode);

    /**
     * 按批量插入股票历史记录，用于从前端接受csv文件并且解析插入数据库
     * @param historyList 某只股票的历史记录
     * @return 影响（插入）的行数
     */
    Integer addHistoryRecordsBatch(List<StockRecordHistory> historyList);

    /**
     * 从前端create页面插入一条股票历史记录到数据库
     * @param stockRecordHistory 待插入的股票历史记录
     * @return 影响的行数
     */
    Integer insertOne(StockRecordHistory stockRecordHistory);
}
