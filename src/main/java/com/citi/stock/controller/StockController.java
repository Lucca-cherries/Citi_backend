package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.citi.stock.service.IStockService;
import com.citi.stock.util.Finnhub;
import com.citi.stock.util.JsonResult;
import com.citi.stock.util.StockLatestVOWithTotal;
import com.citi.stock.vo.StockLatestVO;
import com.citi.stock.vo.StockVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api/stocks")
@RestController
//@CrossOrigin
public class StockController extends BaseController {
    @Autowired
    private IStockService iStockService;

    @GetMapping("")
    public JsonResult<StockLatestVOWithTotal> showDashboard(
            HttpServletRequest request,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        System.err.println("Rendering dashboard for user " + uid);

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

        // 最终展示在前端的股票最新信息，由三个部分构成：
        // 1.总数 2.分页股票数据库信息 3.分页股票api信息
        // 确保2和3有相同的元素个数
        assert finnhubList.size() == stockVOList.size(): "获取实时股票api和数据库列表数量不一致";

        return new JsonResult<>(OK, new StockLatestVOWithTotal(total, stockVOList, finnhubList));

    }

    @GetMapping("/q")
    public JsonResult<StockLatestVOWithTotal> showConditionDashboard(
            HttpServletRequest request,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("stockName")String stockName,
            @RequestParam("stockCode")String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        System.err.println("Rendering conditional query dashboard for user " + uid
                + " with company=" + stockName + " and symbol=" + stockCode);

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

        // 最终展示在前端的股票最新信息，由三个部分构成：
        // 1.总数 2.分页股票数据库信息 3.分页股票api信息
        // 确保2和3有相同的元素个数
        assert finnhubList.size() == stockVOList.size(): "获取实时股票api和数据库列表数量不一致";

        return new JsonResult<>(OK, new StockLatestVOWithTotal(total, stockVOList, finnhubList));
    }

    @GetMapping("/{stockCode}")
    public JsonResult<StockLatestVO> showDetailOfOne(HttpServletRequest request, @PathVariable("stockCode") String stockCode){
        System.err.println("加载" + stockCode + "详情");
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        return new JsonResult<>(OK, iStockService.getStockLatestVOofOne(uid, stockCode));

    }


}
