package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.entity.UserFavoritesRelation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserFavoritesRelationMapperTests {
    @Autowired
    private UserFavoritesRelationMapper userFavoritesRelationMapper;

    @Test
    public void selectByUid(){
        System.err.println(userFavoritesRelationMapper.selectByUid(1L));
    }

    @Test
    public void deleteByUidAndCode(){
        UserFavoritesRelation userFavoritesRelation = UserFavoritesRelation
                .builder()
                .userfavoritesUserId(1)
                .userfavoritesStockCode("AAPL")
                .build();
        System.err.println(
                userFavoritesRelationMapper.deleteByUidAndCode(userFavoritesRelation));
    }

    @Test
    public void insertOne(){
        UserFavoritesRelation userFavoritesRelation = UserFavoritesRelation
                .builder()
                .userfavoritesUserId(1)
                .userfavoritesStockCode("AAPL")
                .build();
        System.err.println(
                userFavoritesRelationMapper.insertOne(userFavoritesRelation)
        );
    }

}
