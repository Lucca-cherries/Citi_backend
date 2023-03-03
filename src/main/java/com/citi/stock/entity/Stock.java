package com.citi.stock.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @TableName stock
 */
@Data
@Builder
public class Stock implements Serializable {

    private Integer stockId;

    private String stockName;

    private Date stockUpdateDate;

    private String stockCode;

    private static final long serialVersionUID = 1L;
}