package com.citi.stock.service;

import com.citi.stock.entity.UserFavoritesRelation;

import java.util.List;

public interface IUserFavoritesRelationService {
    Integer addOneFavorite(UserFavoritesRelation userFavoritesRelation);

    List<UserFavoritesRelation> getFavoritesByUid(Integer uid);

    Integer deleteByUidAndCode(UserFavoritesRelation record);

}
