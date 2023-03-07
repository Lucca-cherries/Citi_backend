package com.citi.stock.service.impl;

import com.citi.stock.entity.UserFavoritesRelation;
import com.citi.stock.mapper.UserFavoritesRelationMapper;
import com.citi.stock.service.IUserFavoritesRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoritesServiceImpl implements IUserFavoritesRelationService {
    @Autowired
    private UserFavoritesRelationMapper userFavoritesRelationMapper;

    @Override
    public Integer addOneFavorite(UserFavoritesRelation record) {
        return userFavoritesRelationMapper.insertOne(record);
    }

    @Override
    public List<UserFavoritesRelation> getFavoritesByUid(Integer uid) {
        return userFavoritesRelationMapper.selectByUid(Long.valueOf(uid));
    }

    @Override
    public Integer deleteByUidAndCode(UserFavoritesRelation record) {
        return userFavoritesRelationMapper.deleteByUidAndCode(record);
    }
}
