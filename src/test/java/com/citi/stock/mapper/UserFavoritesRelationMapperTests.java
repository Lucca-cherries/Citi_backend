package com.citi.stock.mapper;

import com.citi.stock.entity.Stock;
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
}
