package com.citi.stock.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

/**
 * @TableName stock_system_user
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockSystemUser implements Serializable {
    @Email(message = "请填写正确的邮箱地址")
    private Integer stocksystemuserId;

    private String stocksystemuserName;

    private String stocksystemuserPassword;

    private static final long serialVersionUID = 1L;
}