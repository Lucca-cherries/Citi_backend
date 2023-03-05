package com.citi.stock.controller;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.InsertException;
import com.citi.stock.service.ex.UsernameDuplicateException;
import com.citi.stock.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class StockSystemUserController {
//    @Autowired
//    private IStockSystemUserService stockSystemUserService;
//
//    @PostMapping("/register")
//    @ResponseBody
//    public JsonResult<Void> register(StockSystemUser stockSystemUser) {
//        JsonResult<Void> result = new JsonResult<Void>();
//        try {
//            // 调用业务对象执行注册
//            stockSystemUserService.register(stockSystemUser);
//            // 响应成功
//            result.setState(200);
//        } catch (UsernameDuplicateException e) {
//            // 用户名被占用
//            result.setState(4000);
//            result.setMessage("用户名已经被占用");
//        } catch (InsertException e) {
//            // 插入数据异常
//            result.setState(5000);
//            result.setMessage("注册失败，请联系系统管理员");
//        }
//        return result;
//    }

}
