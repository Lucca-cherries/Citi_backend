package com.citi.stock.util;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class JavaApiTests {
//    @Autowired
//    @Resource
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getDataFromApi(){
        // 发送 GET 请求
        String result = restTemplate
                .getForObject("https://finnhub.io/api/v1/quote" +
                                "?symbol=AAPL&token=cg21dgpr01qibiilj8h0cg21dgpr01qibiilj8hg"
                        , String.class);
        System.err.println("string:" + result);

        Finnhub stockFinnhub = JSON.parseObject(result, Finnhub.class);
        System.err.println("object:" + stockFinnhub);
    }
}
