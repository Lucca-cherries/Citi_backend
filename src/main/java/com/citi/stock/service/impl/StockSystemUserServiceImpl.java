package com.citi.stock.service.impl;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.mapper.StockSystemUserMapper;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.InsertException;
import com.citi.stock.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockSystemUserServiceImpl {
//    @Autowired
//    private StockSystemUserMapper stockSystemUserMapper;
//
//    /*
//     * @description 用户注册
//     * @param stockSystemUser
//     * @return void
//     * @author: Li
//     * @date: 2023/3/4
//     */
//    @Override
//    public void register(StockSystemUser stockSystemUser){
//        String name = stockSystemUser.getStocksystemuserName();
////        StockSystemUser result = stockSystemUserMapper.findByUserName(name);
////        if(result!=null){
////            throw new UsernameDuplicateException("用户名"+name+"已被占用");
////        }
//        int rows =stockSystemUserMapper.insert(stockSystemUser);
//        if(rows!=1){
//            throw new InsertException("注册失败");
//        }
//    }
}
