package com.citi.stock.controller;

import com.citi.stock.entity.Stock;
import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Page;
import com.citi.stock.util.StockVOWithTotal;
import com.citi.stock.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/stocks")
@RestController
public class StockController {
    @Autowired
    private IStockService iStockService;

    @GetMapping("")
    public StockVOWithTotal showDashboard(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size){
        Integer total = iStockService.getTotalNumOfStocks();
        List<StockVO> stockVOList = iStockService.selectStockVOByPage(1, page, size);
        StockVOWithTotal stockVOWithTotal = new StockVOWithTotal(total, stockVOList);
        return stockVOWithTotal;
    }

}
