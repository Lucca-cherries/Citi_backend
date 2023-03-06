package com.citi.stock.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
/**
 * @TableName user_favorites_relation
 */
@Data
@Builder
public class UserFavoritesRelation implements Serializable {
    private Integer userfavoritesUserId;

    private Integer userfavoritesStockId;

    private static final long serialVersionUID = 1L;
}