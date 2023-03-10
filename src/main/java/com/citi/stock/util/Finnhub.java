package com.citi.stock.util;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 用于封装Finnhub上面获得的某条股票的最新信息，volume从iex获取
 */
@Data
@Builder
@AllArgsConstructor
/**
 * 需要加上@JSONField(name="c")映射
 */
public class Finnhub {
    @JSONField(name="c")
    private BigDecimal current; // current price
    @JSONField(name="d")
    private BigDecimal change; // change value
    @JSONField(name="dp")
    private float percent; // percent change
    @JSONField(name="h")
    private BigDecimal high; // high price of the day
    @JSONField(name="l")
    private BigDecimal low; // low price of the day
    @JSONField(name="o")
    private BigDecimal open; // open price of the day
    @JSONField(name="pc")
    private BigDecimal preClose; // previous close price
    @JSONField(name="t")
    private String date; // update date for the latest

    private Integer volume; // volume from iex

//    Finnhub(BigDecimal c, BigDecimal d, float dp, BigDecimal h, BigDecimal l,
//            BigDecimal o, BigDecimal pc, String t){
//        this.current = c;
//        this.change = d;
//        this.percent = dp;
//        this.high = h;
//        this.low = l;
//        this.open = o;
//        this.preClose = pc;
//        this.date = Timestamp.timeStamp2Date(t, null);
//    }
}
