package com.citi.stock.service;

import com.citi.stock.entity.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> getByPage(Integer page, Integer size);

}
