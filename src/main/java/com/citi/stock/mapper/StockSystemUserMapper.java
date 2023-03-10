package com.citi.stock.mapper;

import com.citi.stock.entity.StockSystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author bananaa
* @description 针对表【stock_system_user】的数据库操作Mapper
* @createDate 2023-03-01 22:26:11
* @Entity com.citi.stock.entity.StockSystemUser
 */
public interface StockSystemUserMapper {

    /**
     * 根据用户名删除用户（用户名不重复）
     * @param username 用户名
     * @return 影响的行数
     */
    int deleteByUsername(String username);

    /**
     * 插入一条用户信息
     * @param record 用户信息
     * @return 影响的行数
     */
    int insert(StockSystemUser record);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息
     */
    StockSystemUser findByUserName(String username);


    /**
     * 更新密码
     * @param record 用户信息
     * @return 影响的行数
     */
    int updateByPrimaryKey(StockSystemUser record);

}
