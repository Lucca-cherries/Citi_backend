package com.citi.stock.controller;

import com.citi.stock.controller.ex.FileEmptyException;
import com.citi.stock.controller.ex.FileUploadException;
import com.citi.stock.entity.StockRecordHistory;
import com.citi.stock.service.IStockRecordHistoryService;
import com.citi.stock.util.JsonResult;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/stockhistories")
@RestController
//@CrossOrigin
public class StockRecordHistoryController extends BaseController {
    @Autowired
    private IStockRecordHistoryService iStockRecordHistoryService;

    @GetMapping("/{stockCode}")
    public List<StockRecordHistory> getHistoryOfAStock(
            @PathVariable("stockCode") String stockCode){
        System.err.println("Getting history of" + stockCode);
        List<StockRecordHistory> historyList =
                iStockRecordHistoryService.getHistotyOfAStock(stockCode);
        return historyList;
    }

    @PostMapping("/upload")
    // upload拼错了会报Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' not supported]
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        // register converter from String to Date
        DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd");
        ConvertUtils.register(converter, Date.class);

        // validate file
        if (file.isEmpty()) {
            throw new FileEmptyException("上传文件为空");
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<StockRecordHistory> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(StockRecordHistory.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of StockRecordHistory
                List<StockRecordHistory> historyList = csvToBean.parse();

                // TODO: save in DB?
                iStockRecordHistoryService.addHistoryRecordsBatch(historyList);

            } catch (Exception ex) {
                System.err.println("文件上传异常");
                throw new FileUploadException("文件上传异常");
            }
        }

        return "file-uploaded";
    }

    @PostMapping
    public JsonResult<Void> addOneHistoryRecord(@RequestBody StockRecordHistory stockRecordHistory){
        System.err.println("add" + stockRecordHistory);
        iStockRecordHistoryService.insertOne(stockRecordHistory);
        return new JsonResult<>(OK);
    }
}
