package com.citi.stock.mapper;

import com.citi.stock.entity.UserFavoritesRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author bananaa
* @description 针对表【user_favorites_relation】的数据库操作Mapper
* @createDate 2023-03-06 10:00:25
* @Entity com.citi.stock.entity.UserFavoritesRelation
*/
@Repository
public interface UserFavoritesRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserFavoritesRelation record);

    int insertSelective(UserFavoritesRelation record);

//    UserFavoritesRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFavoritesRelation record);

    int updateByPrimaryKey(UserFavoritesRelation record);

    List<UserFavoritesRelation> selectByUid(Long id);

}
