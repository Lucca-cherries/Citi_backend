package com.citi.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.citi.stock.entity.Stock;
import com.citi.stock.mapper.StockMapper;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Finnhub;
import com.citi.stock.util.Timestamp;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private StockMapper stockMapper;
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Stock> getByPage(Integer page, Integer size) {
        log.debug("Service: Get by page {}, size {}", page, size);
        return stockMapper.selectByPage(page*size, size);
    }

    @Override
    public List<StockVO> getStockVOByPage(Integer uid, Integer page, Integer size) {
        log.debug("Service: Get stockVOBy page {}, size {}, user {}", page, size, uid);
        return stockMapper.selectStockVOByPage(uid, (page-1)*size, size);
    }

    @Override
    public List<StockVO> conditionGetStockVOByPage(Integer uid, Integer page, Integer size,
                                                   String stockName, String stockCode) {
        log.debug("Service: Condition select stockVO, page {}, size {}, stockName {}, stockCode {}, user {}"
                , page, size, stockName, stockCode, uid);
        return stockMapper.conditionSelectStockVOByPage(uid, (page-1)*size, size, stockName, stockCode);
    }

    @Override
    public Integer getTotalNumOfStocks() {
        log.debug("Service: Get total number of stock.");
        return stockMapper.getTotalNum();
    }

    @Override
    public Integer getTotalConditionNum(String stockName, String stockCode) {
        log.debug("Service: Condition get total number of stock. stockname {}, stockcode {}", stockName, stockCode);
        return stockMapper.getTotalConditionNum(stockName, stockCode);
    }

    @Override
    public List<Finnhub> getFinnhub(List<String> stockCodes) {
        log.debug("Service: Get finnhub for {}", stockCodes);
        List<Finnhub> finnhubList = new ArrayList<>();
        for(String stockCode: stockCodes){
            String url = "https://finnhub.io/api/v1/quote?symbol=" +
                    stockCode + "&token=cg21dgpr01qibiilj8h0cg21dgpr01qibiilj8hg";
            String res = restTemplate.getForObject(url, String.class);
            log.debug("Service: {}", res);

            Finnhub stockFinnhub = JSON.parseObject(res, Finnhub.class); // 其中date还是时间戳
            stockFinnhub.setDate(Timestamp.timeStamp2Date(stockFinnhub.getDate(), null));
            log.debug("Service: Finnhub {}", stockFinnhub);

            // 从iex上获取volume
            String volumeUrl = "https://api.iex.cloud/v1/data/CORE/QUOTE/" +
                    stockCode + "?token=sk_454461c9456640bc93c1f53513938073";
            String volumeRes = restTemplate.getForObject(volumeUrl, String.class);
            log.debug("Service: get volume from iex: {}", volumeRes);
            JSONArray jobj = JSON.parseObject(volumeRes, JSONArray.class);//封装成一个JSON对象
            log.debug("Service: iex volume object {}", jobj);
            Integer volume = ((JSONObject) jobj.get(0)).getInteger("avgTotalVolume");
            log.debug("Service: volume {}", volume);
            stockFinnhub.setVolume(volume);

            finnhubList.add(stockFinnhub);
        }
        return finnhubList;
    }

    @Override
    public StockVO getStockVOByCode(Integer uid, String code) {
        log.debug("Service: Get stockVO of {} for user {}", code, uid);
        return stockMapper.selectStockVOByCode(uid, code);
    }

    @Override
    public StockLatestVO getStockLatestVOofOne(Integer uid, String code) {
        log.debug("Service: Get StockLatestVO of {} for user {}", code, uid);
        StockVO stockVO = getStockVOByCode(uid, code);
        List<String> singleCode = new ArrayList<>();
        singleCode.add(code);
        log.debug("Service: Get finnhub for {}", singleCode);
        Finnhub finnhub = getFinnhub(singleCode).get(0);
        return new StockLatestVO(stockVO, finnhub);
    }
}
