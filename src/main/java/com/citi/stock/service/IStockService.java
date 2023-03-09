package com.citi.stock.service;

import com.citi.stock.entity.Stock;
import com.citi.stock.util.Finnhub;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;

import java.util.List;

public interface IStockService {
    /**
     * 分页查找股票，暂未使用
     * @param page 页码，从0开始
     * @param size 一页条数
     * @return 股票列表
     */
    List<Stock> getByPage(Integer page, Integer size);

    /**
     * 分页查询StockVO
     * @param uid 用户i，用于判断是否收藏改股票
     * @param page 起始页码
     * @param size 一页条数
     * @return StockVO列表
     */
    List<StockVO> getStockVOByPage(Integer uid, Integer page, Integer size);

    List<StockVO> conditionGetStockVOByPage(Integer uid, Integer page, Integer size,
                                            String stockName, String stockCode);

    /**
     * 获得所有股票的个数
     * @return 所有股票的个数
     */
    Integer getTotalNumOfStocks();

    /**
     * 根据symbol获得Finnhub上的实时数据接口，用于展示在前端表单中
     * @param stockCodes 股票symbol列表
     * @return 实时数据列表
     */
    List<Finnhub> getFinnhub(List<String> stockCodes);

    /**
     * 通过股票symbol获得StockVO，包含收藏信息
     * @param uid token用户id
     * @param code 股票symbol
     * @return StockVO
     */
    StockVO getStockVOByCode(Integer uid, String code);

    /**
     * 通过股票symbol获得StockLatestVO，包含StockVO和Finnhub接口
     * @param uid token用户id
     * @param code 股票symbol
     * @return StockLatestVO
     */
    StockLatestVO getStockLatestVOofOne(Integer uid, String code);

}
