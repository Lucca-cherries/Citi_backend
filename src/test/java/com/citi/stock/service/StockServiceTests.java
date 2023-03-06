package com.citi.stock.service;

import com.citi.stock.vo.StockVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author li
 * @description
 * @createDate 2023-3-4
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTests {
    @Autowired
    private IStockService iStockService;

    @Test
    public void selectByPage(){
        System.err.println(iStockService.getByPage(1, 10));
    }

    @Test
    public void selectStockVOByPage() {
        System.err.println(iStockService.selectStockVOByPage(1, 1*2, 2));
    }
}
