package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import org.springframework.stereotype.Repository;

/**
* @author bananaa
* @description 针对表【stock】的数据库操作Mapper
* @createDate 2023-03-01 22:26:11
* @Entity com.citi.stock.entity.Stock
*/
@Repository
public interface StockMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

}
