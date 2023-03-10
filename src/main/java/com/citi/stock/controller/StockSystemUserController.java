package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.service.IStockSystemUserService;
import com.citi.stock.service.ex.InsertException;
import com.citi.stock.service.ex.UsernameDuplicateException;
import com.citi.stock.util.JWTUtils;
import com.citi.stock.util.JsonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;


@RestController
@RequestMapping("/api/users")
@Validated
@Tag(name = "系统用户管理接口", description = "系统用户管理")
//@CrossOrigin
public class StockSystemUserController extends BaseController {
    @Autowired
    private IStockSystemUserService stockSystemUserService;

    /*
     * @description 用户注册接口
     * @param stockSystemUser
     * @return com.citi.stock.util.JsonResult<java.lang.Void>
     * @author: Li
     * @date: 2023/3/5
     */
    @Operation(summary = "注册用户")
    @PostMapping("/reg")
    public JsonResult<Void> register(@Validated @RequestBody StockSystemUser stockSystemUser) {
        JsonResult<Void> result = new JsonResult<>();
        try {
            System.err.println("新用户请求注册：" + stockSystemUser.getStocksystemuserName());
            // 调用业务对象执行注册
            stockSystemUserService.register(stockSystemUser);
            // 响应成功
            result.setState(OK);
        } catch (UsernameDuplicateException e) {
            // 用户名被占用
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } catch (InsertException e) {
            // 插入数据异常
            result.setState(4000);
            result.setMessage("注册失败，请联系系统管理员");
        }
        return result;
    }

    /**
     * 用户登录
     * @param email 用户邮箱
     * @param pwd 用户密码
     * @return 返回token和HTTP状态
     */
    @Operation(summary = "用户登录")
    @GetMapping ("/login")
    public JsonResult<String> login(@Valid @Email(message = "请输入正确的邮箱格式") @RequestParam("email") String email,
                                    @RequestParam("pwd") String pwd) {
        StockSystemUser data = stockSystemUserService.login(email, pwd);
        System.err.println("用户" + email + "请求登录");
        String token = JWTUtils.getToken(data); // 有id

        return new JsonResult<>(OK, token);
    }


    /*
     * @description 用户注销接口
     * @param uid
     * @return com.citi.stock.util.JsonResult<java.lang.Void>
     * @author: Li
     * @date: 2023/3/6
     */
    @Operation(summary = "注销用户")
    @DeleteMapping("/{username}")
    @ResponseBody
    public JsonResult<Void> deleteUser(HttpServletRequest request, @PathVariable("username") String username) {
        System.err.println("用户注销");
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();

        JsonResult<Void> result = new JsonResult<>();
        stockSystemUserService.deleteUser(uid, username);
        result.setState(OK);
        return result;
    }

}
