package com.citi.stock.service;

import com.citi.stock.entity.Stock;
import com.citi.stock.vo.StockVO;

import java.util.List;

public interface IStockService {
    List<Stock> getByPage(Integer page, Integer size);

    List<StockVO> selectStockVOByPage(Integer uid, Integer start, Integer offset);

}
