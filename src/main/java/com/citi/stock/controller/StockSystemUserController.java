package com.citi.stock.controller;

import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.InsertException;
import com.citi.stock.service.ex.UsernameDuplicateException;
import com.citi.stock.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/users")
public class StockSystemUserController {
    @Autowired
    private IStockSystemUserService stockSystemUserService;

    /*
     * @description 用户注册接口
     * @param stockSystemUser
     * @return com.citi.stock.util.JsonResult<java.lang.Void>
     * @author: Li
     * @date: 2023/3/5
     */
    @PostMapping("/register")
    @ResponseBody
    public JsonResult<Void> register(StockSystemUser stockSystemUser) {
        JsonResult<Void> result = new JsonResult<Void>();
        try {
            // 调用业务对象执行注册
            stockSystemUserService.register(stockSystemUser);
            // 响应成功
            result.setState(200);
        } catch (UsernameDuplicateException e) {
            // 用户名被占用
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } catch (InsertException e) {
            // 插入数据异常
            result.setState(5000);
            result.setMessage("注册失败，请联系系统管理员");
        }
        return result;
    }
    /*
     * @description 用户登录接口
     * @param name
     * @param pwd
     * @return com.citi.stock.util.JsonResult<com.citi.stock.entity.StockSystemUser>
     * @author: Li
     * @date: 2023/3/6
     */
    @GetMapping ("/login")
    @ResponseBody
    public JsonResult<StockSystemUser> login(String name, String pwd) {

        StockSystemUser data = stockSystemUserService.login(name, pwd);

        return new JsonResult<StockSystemUser>(200, data);
    }
    /*
     * @description 修改密码接口
     * @param null
     * @return
     * @author: Li
     * @date: 2023/3/6
     */

    @PutMapping  ("/change_pwd")
    @ResponseBody
    public JsonResult<Void> changePassword(Integer uid, String oldPwd,String newPwd) {
        JsonResult<Void> result = new JsonResult<Void>();
        stockSystemUserService.changePassword(uid, oldPwd, newPwd);
        result.setState(200);
        return result;
    }
    /*
     * @description 修改用户名接口
     * @param uid
     * @param newName
     * @return com.citi.stock.util.JsonResult<java.lang.Void>
     * @author: Li
     * @date: 2023/3/6
     */
    @PutMapping  ("/change_info")
    @ResponseBody
    public JsonResult<Void> changeInfo(Integer uid,String newName) {
        JsonResult<Void> result = new JsonResult<Void>();
        stockSystemUserService.changeInfo(uid,newName);
        result.setState(200);
        return result;
    }
    /*
     * @description 用户注销接口
     * @param uid
     * @return com.citi.stock.util.JsonResult<java.lang.Void>
     * @author: Li
     * @date: 2023/3/6
     */
    @DeleteMapping   ("/delete_a_user/{uid}")
    @ResponseBody
    public JsonResult<Void> deleteUser(@PathVariable("uid") Integer uid) {
        JsonResult<Void> result = new JsonResult<Void>();
        stockSystemUserService.deleteUser(uid);
        result.setState(200);
        return result;
    }

}
