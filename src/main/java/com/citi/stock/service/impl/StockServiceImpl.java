package com.citi.stock.service.impl;

import com.citi.stock.entity.Stock;
import com.citi.stock.mapper.StockMapper;
import com.citi.stock.service.IStockService;
import com.citi.stock.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Stock> getByPage(Integer page, Integer size) {
        return stockMapper.selectByPage(page*size, size);
    }

    @Override
    public List<StockVO> selectStockVOByPage(Integer uid, Integer page, Integer size) {
        return stockMapper.selectStockVOByPage(1, (page-1)*size, size);
    }

    @Override
    public Integer getTotalNumOfStocks() {
        return stockMapper.getTotalNum();
    }
}
