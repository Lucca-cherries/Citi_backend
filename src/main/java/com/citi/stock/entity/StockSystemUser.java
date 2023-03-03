package com.citi.stock.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName stock_system_user
 */
@Data
public class StockSystemUser implements Serializable {
    private Integer stocksystemuserId;

    private String stocksystemuserName;

    private String stocksystemuserPasword;

    private static final long serialVersionUID = 1L;
}