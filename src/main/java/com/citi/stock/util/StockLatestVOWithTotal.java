package com.citi.stock.util;

import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;

import java.util.List;

/**
 * 最新股票信息类
 * 包含数据库信息StockVO和第三方接口信息
 */
public class StockLatestVOWithTotal {
    public final Integer total;
    public final List<StockVO> stockVOList;
    public final List<Finnhub> finnhubList;

    public StockLatestVOWithTotal(Integer total, List<StockVO> stockVOList,
                                  List<Finnhub> finnhubList){
        this.total = total;
        this.stockVOList = stockVOList;
        this.finnhubList = finnhubList;
    }
}
