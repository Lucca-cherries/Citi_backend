package com.citi.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName stock_record
 */
@Data
// 应该用不上了
public class StockRecord implements Serializable {
    private Integer stockrecordId;

    private Date stockrecordDatetime;

    private BigDecimal stockrecordLow;

    private BigDecimal stockrecordHigh;

    private BigDecimal stockrecordPercent;

    private BigDecimal stockrecordValue;

    private Double stockrecordVolume;

    private Double stockrecordTurnover;

    private Integer stockId;

    private BigDecimal stockrecordOpenPrice;

    private BigDecimal stockrecordEndPrice;

    private BigDecimal stockrecordLastEndPrice;

    private static final long serialVersionUID = 1L;
}