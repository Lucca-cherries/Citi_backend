package com.citi.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.citi.stock.entity.Stock;
import com.citi.stock.mapper.StockMapper;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Finnhub;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    private StockMapper stockMapper;
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Stock> getByPage(Integer page, Integer size) {
        return stockMapper.selectByPage(page*size, size);
    }

    @Override
    public List<StockVO> getStockVOByPage(Integer uid, Integer page, Integer size) {
        return stockMapper.selectStockVOByPage(1, (page-1)*size, size);
    }

    @Override
    public Integer getTotalNumOfStocks() {
        return stockMapper.getTotalNum();
    }

    @Override
    public List<Finnhub> getFinnhub(List<String> stockCodes) {
        List<Finnhub> finnhubList = new ArrayList<>();
        for(String stockCode: stockCodes){
            String url = "https://finnhub.io/api/v1/quote?symbol=" +
                    stockCode + "&token=cg21dgpr01qibiilj8h0cg21dgpr01qibiilj8hg";
            String res = restTemplate.getForObject(url, String.class);

            Finnhub stockFinnhub = JSON.parseObject(res, Finnhub.class);
            finnhubList.add(stockFinnhub);
        }
        return finnhubList;
    }
}
