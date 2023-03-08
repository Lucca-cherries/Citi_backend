package com.citi.stock.service;

import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.entity.UserFavoritesRelation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @description
 * @createDate 2023-3-4
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFavoritesServiceTests {
    @Autowired
    private IUserFavoritesRelationService iUserFavoritesRelationService;

    @Test
    public void addOneFavorite(){
        UserFavoritesRelation relation = UserFavoritesRelation.builder()
                .userfavoritesUserId(4)
                .userfavoritesStockCode("MSFT").build();
        assert iUserFavoritesRelationService.addOneFavorite(relation).equals(1);
    }

    @Test
    public void getFavoritesByUid(){
        System.err.println(iUserFavoritesRelationService.getFavoritesByUid(1));
    }

    @Test
    public void deleteByUidAndCode(){
        UserFavoritesRelation relation = UserFavoritesRelation.builder()
                .userfavoritesUserId(1)
                .userfavoritesStockCode("AAPL").build();
        assert iUserFavoritesRelationService.deleteByUidAndCode(relation) == 1;
    }
}
