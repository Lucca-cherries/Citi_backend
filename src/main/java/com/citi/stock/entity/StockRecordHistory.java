package com.citi.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.citi.stock.util.StringToDate;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName stock_record_history
 */
@Data
@Builder
public class StockRecordHistory implements Serializable {
    @CsvBindByName
    private Integer stockrecordId;
    @CsvBindByName
    private String stockCode;
    @CsvCustomBindByName(column = "stockrecordDate", converter = StringToDate.class) // debug了一天，一直转化不起
    private Date stockrecordDate;
    @CsvBindByName
    private BigDecimal stockrecordOpenPrice;
    @CsvBindByName
    private BigDecimal stockrecordEndPrice;
    @CsvBindByName
    private BigDecimal stockrecordLow;
    @CsvBindByName
    private BigDecimal stockrecordHigh;
    @CsvBindByName
    private Double stockrecordVolume;

    private static final long serialVersionUID = 1L;


    public StockRecordHistory(Integer stockrecordId, String stockCode, Date stockrecordDate
            , BigDecimal stockrecordOpenPrice, BigDecimal stockrecordEndPrice, BigDecimal stockrecordLow
            , BigDecimal stockrecordHigh, Double stockrecordVolume){
        this.stockrecordId = stockrecordId;
        this.stockCode = stockCode;
        this.stockrecordDate =  stockrecordDate;
        this.stockrecordOpenPrice = stockrecordOpenPrice;
        this.stockrecordEndPrice = stockrecordEndPrice;
        this.stockrecordLow = stockrecordLow;
        this.stockrecordHigh = stockrecordHigh;
        this.stockrecordVolume = stockrecordVolume;
    }

    public StockRecordHistory(String stockCode) {
        this.stockCode = stockCode;
    }

    public StockRecordHistory(){}
}