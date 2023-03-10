package com.citi.stock.service;

import com.citi.stock.entity.StockSystemUser;

public interface IStockSystemUserService {
    /*
     * @description 用户注册
     * @param stockSystemUser
     * @return void
     * @author: Li
     * @date: 2023/3/4
     */
    void register(StockSystemUser stockSystemUser);

    /*
     * @description 用户登录
     * @param email
     * @param pwd
     * @return com.citi.stock.entity.StockSystemUser
     * @author: Li
     * @date: 2023/3/5
     */
    StockSystemUser login(String email,String pwd);


    /*
     * @description 注销用户
     * @param username
     * @return void
     * @author: Li
     * @date: 2023/3/5
     */
    void deleteUser(Integer uid, String username);
    /*
     * @description
     * @param uid
     * @param newPwd
     * @return void
     * @author: Li
     * @date: 2023/3/10
     */
    void changePwd(String email,String oldPwd,String newPwd);


}
