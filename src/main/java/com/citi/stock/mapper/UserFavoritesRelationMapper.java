package com.citi.stock.mapper;

import com.citi.stock.entity.UserFavoritesRelation;

/**
* @author bananaa
* @description 针对表【user_favorites_relation】的数据库操作Mapper
* @createDate 2023-03-01 22:26:11
* @Entity com.citi.stock.entity.UserFavoritesRelation
*/
public interface UserFavoritesRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserFavoritesRelation record);

    int insertSelective(UserFavoritesRelation record);

    UserFavoritesRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFavoritesRelation record);

    int updateByPrimaryKey(UserFavoritesRelation record);

}
