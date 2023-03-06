package com.citi.stock.util;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用于封装Finnhub上面获得的某条股票的最新信息
 */
@Data
@Builder
public class Finnhub {
    private BigDecimal c; // current price
    private BigDecimal d; // change value
    private float dp; // percent change
    private BigDecimal h; // high price of the day
    private BigDecimal l; // low price of the day
    private BigDecimal o; // open price of the day
    private BigDecimal pc; // previous close price
}
