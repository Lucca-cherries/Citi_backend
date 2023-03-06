package com.citi.stock.util;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于封装Finnhub上面获得的某条股票的最新信息
 */
@Data
@Builder
public class Finnhub {
    private BigDecimal current; // current price
    private BigDecimal change; // change value
    private float percent; // percent change
    private BigDecimal high; // high price of the day
    private BigDecimal low; // low price of the day
    private BigDecimal open; // open price of the day
    private BigDecimal preClose; // previous close price
    private String date; // update date for the latest

    Finnhub(BigDecimal c, BigDecimal d, float dp, BigDecimal h, BigDecimal l,
            BigDecimal o, BigDecimal pc, String t){
        this.current = c;
        this.change = d;
        this.percent = dp;
        this.high = h;
        this.low = l;
        this.open = o;
        this.preClose = pc;
        this.date = timeStamp.timeStamp2Date(t, null);
    }
}
