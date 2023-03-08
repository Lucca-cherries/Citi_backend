package com.citi.stock.vo;

import com.citi.stock.util.Finnhub;
import lombok.Builder;
import lombok.Data;

/**
 * 用于封装第三方api实时数据到对象中
 * 显示于股票详情页面
 */
@Data
@Builder
public class StockLatestVO {
    private StockVO stockVO;

    private Finnhub finnhub;

    public StockLatestVO(StockVO stockVO, Finnhub finnhub){
        this.stockVO = stockVO;
        this.finnhub = finnhub;
    }
}
