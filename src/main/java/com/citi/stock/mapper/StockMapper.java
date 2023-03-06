package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
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

    /**
     * 不同股票面板上的显示数据，数据库持久层部分
     * @param uid 当前用户id，用于判断是否被收藏
     * @param start 分页起始下标
     * @param size 分类偏移量（一页有多少条数据）
     * @return 最新股票持久层数据list
     */
    List<StockVO> selectStockVOByPage(Integer uid, Integer start, Integer size);
}
