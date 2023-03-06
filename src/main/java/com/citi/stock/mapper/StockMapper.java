package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author bananaa
* @description 针对表【stock】的数据库操作Mapper
* @createDate 2023-03-06 09:50:22
* @Entity com.citi.stock.entity.Stock
*/
@Repository
public interface StockMapper {

    int insert(Stock record);

    Stock selectByPrimaryKey(Long id);

    Integer getTotalNum();

    List<Stock> selectByPage(Integer start, Integer offset);


}
