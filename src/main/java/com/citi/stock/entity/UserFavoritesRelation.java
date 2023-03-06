package com.citi.stock.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @TableName user_favorites_relation
 * 这个表没有设置主键
 */
@Data
public class UserFavoritesRelation implements Serializable {
    private Integer userfavoritesUserId;

    private String userfavoritesStockCode;

    private static final long serialVersionUID = 1L;
}