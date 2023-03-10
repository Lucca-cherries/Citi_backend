package com.citi.stock.service.impl;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.mapper.StockSystemUserMapper;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockSystemUserServiceImpl implements IStockSystemUserService{
    @Resource
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
            throw new UsernameDuplicateException("邮箱"+name+"已被占用");
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
    public StockSystemUser login(String email, String pwd) {

        StockSystemUser result =  stockSystemUserMapper.findByUserName(email);
        if (result == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (!result.getStocksystemuserPassword().equals(pwd)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("密码错误");
        }

        return result;
    }


    /*
     * @description 注销用户
     * @param uid
     * @return void
     * @author: Li
     * @date: 2023/3/6
     */
    @Override
    public void deleteUser(Integer uid, String username) {
        // 获取原用户id
        Integer originalUid = stockSystemUserMapper.findByUserName(username).getStocksystemuserId();
        // 只有原用户id和token用户id匹配才能执行删除功能
        if (uid.equals(originalUid)){
            int rows=stockSystemUserMapper.deleteByUsername(username);
            if (rows != 1) {
                throw new UpdateException("注销用户失败，请联系系统管理员");
            }
        } else {
            throw new UpdateException("权限不足");
        }
    }

    @Override
    public void changePwd(String email, String oldPwd,String newPwd) {
        StockSystemUser stockSystemUser = stockSystemUserMapper.findByUserName(email);
        if (stockSystemUser==null) {
            throw new UserNotFoundException("用户不存在");
        }
        if ((stockSystemUser.getStocksystemuserPassword()).equals(oldPwd)) {
            stockSystemUser.setStocksystemuserPassword(newPwd);
            int rows = stockSystemUserMapper.updateByPrimaryKey(stockSystemUser);
            if (rows != 1) {
                throw new UpdateException("修改密码失败，请联系系统管理员");
            }
        } else {
            throw new PasswordNotMatchException("密码输入错误，请重试");
        }

    }
}