package com.citi.stock.vo;

import com.citi.stock.util.Finnhub;
import lombok.Builder;
import lombok.Data;

/**
 * 最新股票数据,存在数据库内的字段对象
 */
@Data
@Builder
public class StockVO {
    private String stockCode;

    private String stockName;

    private String svg;

    private Integer isFavourite;

//    StockVO(){
//        // 默认收藏为0，表示未收藏
//        this.isFavourite = 0;
//    }
}
