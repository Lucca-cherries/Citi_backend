package com.citi.stock.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName stock
 */
@Data
@Builder
public class Stock implements Serializable {
    private Integer stockId;

    private String stockCode;

    private String stockName;

    private Date stockUpdateDate;

    private String stockSvg;

    private static final long serialVersionUID = 1L;
}