package com.citi.stock.service.impl;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.mapper.StockSystemUserMapper;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StockSystemUserServiceImpl implements IStockSystemUserService{
    @Autowired
    private StockSystemUserMapper stockSystemUserMapper;

    /*
     * @description 用户注册
     * @param stockSystemUser
     * @return void
     * @author: Li
     * @date: 2023/3/4
     */
    @Override
    public void register(StockSystemUser stockSystemUser){
        String name = stockSystemUser.getStocksystemuserName();
        StockSystemUser result = stockSystemUserMapper.findByUserName(name);
        if(result!=null){
            throw new UsernameDuplicateException("用户名"+name+"已被占用");
        }
        int rows =stockSystemUserMapper.insert(stockSystemUser);
        if(rows!=1){
            throw new InsertException("注册失败");
        }
    }
    /*
     * @description 用户登录
     * @param name
     * @param pwd
     * @return com.citi.stock.entity.StockSystemUser
     * @author: Li
     * @date: 2023/3/5
     */
    @Override
    public StockSystemUser login(String name, String pwd) {

        StockSystemUser result =  stockSystemUserMapper.findByUserName(name);
        if (result == null) {
            throw new UserNotFoundException("用户名错误");
        }
        if (!result.getStocksystemuserPasword().equals(pwd)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("密码错误");
        }
        StockSystemUser stockSystemUser= StockSystemUser.builder()
                .stocksystemuserName(result.getStocksystemuserName())
                .stocksystemuserPasword(result.getStocksystemuserPasword())
                .build();
        return stockSystemUser;
    }

    /*
     * @description 修改密码
     * @param uid
     * @param username
     * @param oldPwd
     * @param newPwd
     * @return void
     * @author: Li
     * @date: 2023/3/5
     */
    @Override
    public void changePassword(Integer uid, String oldPwd, String newPwd) {

        StockSystemUser result = stockSystemUserMapper.selectByPrimaryKey((long)uid);

        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        if (!result.getStocksystemuserPasword().contentEquals(oldPwd)) {
            throw new PasswordNotMatchException("原密码错误");
        }

        result.setStocksystemuserPasword(newPwd);
        Integer rows = stockSystemUserMapper.updateByPrimaryKey(result);
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }

    }
    /*
     * @description 修改用户名
     * @param uid
     * @param newName
     * @return void
     * @author: Li
     * @date: 2023/3/6
     */
    @Override
    public void changeInfo(Integer uid, String newName) {
        StockSystemUser result = stockSystemUserMapper.selectByPrimaryKey((long)uid);

        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        result.setStocksystemuserName(newName);
        Integer rows = stockSystemUserMapper.updateByPrimaryKey(result);
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }
    /*
     * @description 注销用户
     * @param uid
     * @return void
     * @author: Li
     * @date: 2023/3/6
     */
    @Override
    public void deleteUser(Integer uid) {
        int rows=stockSystemUserMapper.deleteByPrimaryKey((long)uid);
        if (rows != 1) {
            throw new UpdateException("注销用户失败，请联系系统管理员");
        }
    }
}