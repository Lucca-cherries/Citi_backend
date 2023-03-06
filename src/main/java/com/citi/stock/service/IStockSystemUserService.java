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
     * @param name
     * @param pwd
     * @return com.citi.stock.entity.StockSystemUser
     * @author: Li
     * @date: 2023/3/5
     */
    StockSystemUser login(String name,String pwd);

    /*
     * @description 修改密码
     * @param uid
     * @param oldPwd
     * @param newPwd
     * @return void
     * @author: Li
     * @date: 2023/3/5
     */
    void changePassword(Integer uid, String oldPwd, String newPwd);

    /*
     * @description 修改用户名
     * @param uid
     * @param newName
     * @return void
     * @author: Li
     * @date: 2023/3/5
     */
    void changeInfo(Integer uid, String newName);

    /*
     * @description 注销用户
     * @param uid
     * @return void
     * @author: Li
     * @date: 2023/3/5
     */
    void deleteUser(Integer uid);




}
