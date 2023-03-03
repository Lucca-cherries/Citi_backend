package com.citi.stock.mapper;

import com.citi.stock.entity.StockRecord;

/**
* @author bananaa
* @description 针对表【stock_record】的数据库操作Mapper
* @createDate 2023-03-01 22:26:11
* @Entity com.citi.stock.entity.StockRecord
*/
public interface StockRecordMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockRecord record);

    int insertSelective(StockRecord record);

    StockRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockRecord record);

    int updateByPrimaryKey(StockRecord record);

}
