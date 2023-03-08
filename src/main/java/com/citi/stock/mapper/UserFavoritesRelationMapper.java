package com.citi.stock.mapper;

import com.citi.stock.entity.UserFavoritesRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author bananaa
* @description 针对表【user_favorites_relation】的数据库操作Mapper
* @createDate 2023-03-06 10:00:25
* @Entity com.citi.stock.entity.UserFavoritesRelation
*/

public interface UserFavoritesRelationMapper {

    /**
     * 插入收藏数据
     * @param record 收藏数据，包含用户id和股票code两个属性
     * @return 影响的行数
     */
    int insertOne(UserFavoritesRelation record);

    /**
     * 按照用户id查找收藏列表
     * @param uid 用户id
     * @return 收藏列表
     */
    List<UserFavoritesRelation> selectByUid(Long uid);

    /**
     * 删除一条收藏记录，要求uid和code同时匹配上
     * @param record 待删除的记录
     * @return 受影响的行数
     */
    int deleteByUidAndCode(UserFavoritesRelation record);

}
