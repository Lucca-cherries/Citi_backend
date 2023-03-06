package com.citi.stock.mapper;

import com.citi.stock.entity.StockSystemUser;
import org.springframework.stereotype.Repository;

/**
* @author bananaa
* @description 针对表【stock_system_user】的数据库操作Mapper
* @createDate 2023-03-01 22:26:11
* @Entity com.citi.stock.entity.StockSystemUser
*/
@Repository
public interface StockSystemUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockSystemUser record);

    int insertSelective(StockSystemUser record);

    StockSystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockSystemUser record);

    int updateByPrimaryKey(StockSystemUser record);
    StockSystemUser findByUserName(String username);
}
