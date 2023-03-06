package com.citi.stock.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 用于封装第三方api实时数据到对象中
 */
@Data
@Builder
public class StockLatest {
    private Integer stockId;

    private String stockName;

    private Date stockUpdateDate;

    private String stockCode;

    private static final long serialVersionUID = 1L;
}
