package com.citi.stock.util;

import com.citi.stock.vo.StockVO;

import java.util.List;

public class StockVOWithTotal {
    public final Integer total;
    public final List<StockVO> stockVOList;

    public StockVOWithTotal(Integer total, List<StockVO> stockVOList){
        this.total = total;
        this.stockVOList = stockVOList;
    }
}
