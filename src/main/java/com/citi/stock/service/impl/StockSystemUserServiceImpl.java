package com.citi.stock.service.impl;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.mapper.StockSystemUserMapper;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
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
        log.debug("Service: user {} register", name);
        StockSystemUser result = stockSystemUserMapper.findByUserName(name);
        if(result!=null){
            log.error("Service: user {} already exists.", name);
            throw new UsernameDuplicateException("邮箱"+name+"已被占用");
        }
        int rows =stockSystemUserMapper.insert(stockSystemUser);
        if(rows!=1){
            log.error("Service: register error with database, insert {}", rows);
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
        log.debug("Service: user {} try to log in.", email);
        StockSystemUser result =  stockSystemUserMapper.findByUserName(email);
        if (result == null) {
            log.error("Service: User {} does not exist.", email);
            throw new UserNotFoundException("User not Exist.");
        }
        if (!result.getStocksystemuserPassword().equals(pwd)) {
            // 是：抛出PasswordNotMatchException异常
            log.error("User {} log in failed with wrong password.", email);
            throw new PasswordNotMatchException("Wrong password.");
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
                throw new UpdateException("Database Update Error. Please Contact Admin.");
            }
        } else {
            throw new UpdateException("Permission Denied.");
        }
    }

    @Override
    public void changePwd(String email, String oldPwd,String newPwd) {
        log.debug("Service: User {} try to change password.", email);
        StockSystemUser stockSystemUser = stockSystemUserMapper.findByUserName(email);
        if (stockSystemUser==null) {
            log.error("Service: User {} not exists.", email);
            throw new UserNotFoundException("User Not Exist.");
        }
        if ((stockSystemUser.getStocksystemuserPassword()).equals(oldPwd)) {
            stockSystemUser.setStocksystemuserPassword(newPwd);
            int rows = stockSystemUserMapper.updateByPrimaryKey(stockSystemUser);
            if (rows != 1) {
                log.error("Service: Fail to change password with database for user {}.", email);
                throw new UpdateException("Fail to change password with database error.");
            }
        } else {
            log.error("Wrong password for user {}", email);
            throw new PasswordNotMatchException("Wrong Password.");
        }

    }
}