package com.citi.stock.mapper;

import com.citi.stock.entity.StockRecordHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author bananaa
* @description 针对表【stock_record_history】的数据库操作Mapper
* @createDate 2023-03-06 09:50:22
* @Entity com.citi.stock.entity.StockRecordHistory
*/
@Repository
public interface StockRecordHistoryMapper {

    /**
     * 插入一条股票历史记录，暂未使用
     * @param record 股票历史记录
     * @return 影响的行数
     */
    int insert(StockRecordHistory record);

    /**
     * 根据股票symbol查找所有历史记录
     * @param stockCode 股票symbol
     * @return 该股票的所有历史记录
     */
    List<StockRecordHistory> selectByStockCode(String stockCode);

    /**
     * 按批量插入股票历史记录
     * @param historyList 股票历史记录列表
     * @return 影响的行数
     */
    int insertBatch(List<StockRecordHistory> historyList);

}
