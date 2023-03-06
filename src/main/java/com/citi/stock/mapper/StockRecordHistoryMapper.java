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

//    int deleteByPrimaryKey(Long id);

    int insert(StockRecordHistory record);

//    int insertSelective(StockRecordHistory record);

    StockRecordHistory selectByPrimaryKey(Long id);

//    int updateByPrimaryKeySelective(StockRecordHistory record);

//    int updateByPrimaryKey(StockRecordHistory record);

    List<StockRecordHistory> selectByStockCode(String stockCode);

}
