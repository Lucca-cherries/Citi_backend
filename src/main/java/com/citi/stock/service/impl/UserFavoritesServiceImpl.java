package com.citi.stock.service.impl;

import com.citi.stock.entity.UserFavoritesRelation;
import com.citi.stock.mapper.UserFavoritesRelationMapper;
import com.citi.stock.service.IUserFavoritesRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserFavoritesServiceImpl implements IUserFavoritesRelationService {
    @Resource
    private UserFavoritesRelationMapper userFavoritesRelationMapper;

    @Override
    public Integer addOneFavorite(UserFavoritesRelation record) {
        log.debug("Service: Insert one favorite {}.", record);
        return userFavoritesRelationMapper.insertOne(record);
    }

    @Override
    public List<UserFavoritesRelation> getFavoritesByUid(Integer uid) {
        log.debug("Service: Get favorites for user {}", uid);
        return userFavoritesRelationMapper.selectByUid(Long.valueOf(uid));
    }

    @Override
    public Integer deleteByUidAndCode(UserFavoritesRelation record) {
        log.debug("Service: Delete {}", record);
        return userFavoritesRelationMapper.deleteByUidAndCode(record);
    }
}
