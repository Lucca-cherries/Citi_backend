package com.citi.stock.service;

import com.citi.stock.entity.Stock;
import com.citi.stock.util.Finnhub;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;

import java.util.List;

public interface IStockService {
    List<Stock> getByPage(Integer page, Integer size);

    List<StockVO> getStockVOByPage(Integer uid, Integer start, Integer offset);

    Integer getTotalNumOfStocks();

    List<Finnhub> getFinnhub(List<String> stockCodes);

    StockVO getStockVOByCode(Integer uid, String code);

    StockLatestVO getStockLatestVOofOne(Integer uid, String code);

}
