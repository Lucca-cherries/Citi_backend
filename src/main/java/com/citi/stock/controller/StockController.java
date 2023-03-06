package com.citi.stock.controller;

import com.citi.stock.entity.Stock;
import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/stocks")
@RestController
public class StockController {
    @Autowired
    private IStockService iStockService;

//    @GetMapping()
//    @ResponseBody
//    public showDashboard(Page page){
//        List<Stock> stockList = iStockService.getByPage(page.getPage(), page.getSize());
//    }

}
