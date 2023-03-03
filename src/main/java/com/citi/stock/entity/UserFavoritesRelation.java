package com.citi.stock.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user_favorites_relation
 */
@Data
public class UserFavoritesRelation implements Serializable {
    private Integer userfavoritesUserId;

    private Integer userfavoritesStockId;

    private static final long serialVersionUID = 1L;
}