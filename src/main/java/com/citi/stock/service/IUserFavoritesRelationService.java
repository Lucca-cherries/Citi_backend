package com.citi.stock.service;

import com.citi.stock.entity.UserFavoritesRelation;

import java.util.List;

public interface IUserFavoritesRelationService {
    /**
     * 添加一条收藏信息
     * @param userFavoritesRelation 收藏信息
     * @return 影响的行数
     */
    Integer addOneFavorite(UserFavoritesRelation userFavoritesRelation);

    /**
     * 通过uid获得收藏列表
     * @param uid token用户id
     * @return 该用户收藏的所有股票symbol列表
     */
    List<UserFavoritesRelation> getFavoritesByUid(Integer uid);

    /**
     * 取消收藏，需要用户id和股票symbol均匹配
     * @param record 待删除的收藏记录
     * @return 影响的行数
     */
    Integer deleteByUidAndCode(UserFavoritesRelation record);

}
