package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.citi.stock.interceptor.ex.JwtException;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Finnhub;
import com.citi.stock.util.JsonResult;
import com.citi.stock.util.StockLatestVOWithTotal;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



@RequestMapping("/api/stocks")
@RestController
@Tag(name = "股票信息展示接口", description = "股票信息控制层")
@Slf4j
//@CrossOrigin
public class StockController extends BaseController {
    @Autowired
    private IStockService iStockService;

    @Operation(summary = "展示所有股票的最新实时详细信息")
    @GetMapping("")
    public JsonResult<StockLatestVOWithTotal> showDashboard(
            HttpServletRequest request,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) throws JwtException{

        try {
            Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
            log.info("Rendering dashboard for user {}, page {}, size {}", uid, page, size);

            // 从数据库获取一部分静态信息
            Integer total = iStockService.getTotalNumOfStocks();
            List<StockVO> stockVOList = iStockService.getStockVOByPage(uid, page, size);

            // 从stockVOList中获取code列表
            List<String> stockCodes = new ArrayList<>();
            for (StockVO stockVO: stockVOList){
                stockCodes.add(stockVO.getStockCode());
            }
            // 请求finnhub api获取最新动态信息
            List<Finnhub> finnhubList = iStockService.getFinnhub(stockCodes);
            log.debug("Dashboard finnhub api: {}", finnhubList);

            // 最终展示在前端的股票最新信息，由三个部分构成：
            // 1.总数 2.分页股票数据库信息 3.分页股票api信息
            // 确保2和3有相同的元素个数
            assert finnhubList.size() == stockVOList.size(): "获取实时股票api和数据库列表数量不一致";

            return new JsonResult<>(OK, new StockLatestVOWithTotal(total, stockVOList, finnhubList));
        } catch (NullPointerException e){
            log.error("Show dashboard for error. Sth. may be wrong with token.");
            throw new JwtException("Token Verification Error.");
        }
    }

    @Operation(summary = "展示满足查询条件股票的最新实时详细信息")
    @GetMapping("/q")
    public JsonResult<StockLatestVOWithTotal> showConditionDashboard(
            HttpServletRequest request,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("stockName")String stockName,
            @RequestParam("stockCode")String stockCode){
        try {
            Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
            log.info("Rendering conditional query dashboard for user {} with company= {} and symbol= {}, page {}, size {}"
                    , uid, stockName, stockCode, page, size);

            // 从数据库获取一部分静态信息
            Integer total = iStockService.getTotalConditionNum(stockName, stockCode);
            List<StockVO> stockVOList = iStockService.conditionGetStockVOByPage(uid, page, size, stockName, stockCode);

            // 从stockVOList中获取code列表
            List<String> stockCodes = new ArrayList<>();
            for (StockVO stockVO: stockVOList){
                stockCodes.add(stockVO.getStockCode());
            }
            // 请求finnhub api获取最新动态信息
            List<Finnhub> finnhubList = iStockService.getFinnhub(stockCodes);
            log.debug("Condition dashboard finnhub api: {}", finnhubList);

            // 最终展示在前端的股票最新信息，由三个部分构成：
            // 1.总数 2.分页股票数据库信息 3.分页股票api信息
            // 确保2和3有相同的元素个数
            assert finnhubList.size() == stockVOList.size(): "获取实时股票api和数据库列表数量不一致";

            return new JsonResult<>(OK, new StockLatestVOWithTotal(total, stockVOList, finnhubList));
        } catch (JWTDecodeException | NullPointerException e) {
            log.error("Show condition dashboard error. Sth. may be wrong with token.");
            throw new JwtException("Token Verification Error.");
        }
    }

    @Operation(summary = "展示某一条股票的实时详细信息")
    @GetMapping("/{stockCode}")
    public JsonResult<StockLatestVO> showDetailOfOne(HttpServletRequest request, @PathVariable("stockCode") String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        log.info("Loading latest detail of {}, for user {}", stockCode, uid);
        return new JsonResult<>(OK, iStockService.getStockLatestVOofOne(uid, stockCode));

    }


}
