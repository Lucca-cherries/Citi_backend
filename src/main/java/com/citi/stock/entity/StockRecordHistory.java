package com.citi.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName stock_record_history
 */
@Data
public class StockRecordHistory implements Serializable {
    private Integer stockrecordId;

    private String stockCode;

    private Date stockrecordDate;

    private BigDecimal stockrecordOpenPrice;

    private BigDecimal stockrecordEndPrice;

    private BigDecimal stockrecordLow;

    private BigDecimal stockrecordHigh;

    private Double stockrecordVolume;

    private static final long serialVersionUID = 1L;
}