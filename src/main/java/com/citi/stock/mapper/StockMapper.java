package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author bananaa
* @description 针对表【stock】的数据库操作Mapper
* @createDate 2023-03-06 09:50:22
* @Entity com.citi.stock.entity.Stock
*/
//@Repository
public interface StockMapper {

    /**
     * 插入一只股票
     * @param record 股票
     * @return 影响的行数
     */
    int insert(Stock record);

    /**
     * 获取数据库中股票的个数
     * @return 数据库中股票的个数
     */
    Integer getTotalNum();

    /**
     * 分页查询股票
     * @param start 起始页
     * @param offset 一页有多少条记录
     * @return 分页擦汗寻结果
     */
    List<Stock> selectByPage(Integer start, Integer offset);

    /**
     * 不同股票面板上的显示数据，数据库持久层部分
     * @param uid 当前用户id，用于判断是否被收藏
     * @param start 分页起始下标
     * @param size 分类偏移量（一页有多少条数据）
     * @return 最新股票持久层数据list
     */
    List<StockVO> selectStockVOByPage(
            @Param("uid")Integer uid,
            @Param("start")Integer start,
            @Param("size")Integer size);

    /**
     * 从url中直接指定具体股票code，查找svg，isFavorite等资料
     * @param uid 用户id
     * @param code 股票symbol
     * @return 该股票的详细信息，包含svg
     */
    StockVO selectStockVOByCode(Integer uid, String code);

    List<StockVO> conditionSelectStockVOByPage(
            @Param("uid")Integer uid,
            @Param("start")Integer start,
            @Param("size")Integer size,
            @Param("stockName")String stockName,
            @Param("stockCode")String stockCode);
}
