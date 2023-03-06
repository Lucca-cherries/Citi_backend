package com.citi.stock.service.impl;

import com.citi.stock.entity.Stock;
import com.citi.stock.mapper.StockMapper;
import com.citi.stock.service.IStockService;
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
}
