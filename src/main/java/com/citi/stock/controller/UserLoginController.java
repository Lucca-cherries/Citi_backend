package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.util.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.citi.stock.util.JWTUtils.verify;

/**
 * @author admin
 */
@RestController
@RequestMapping("user")
public class UserLoginController {

    @Value("${Login.username}")
    private String realUsername;

    @Value("${Login.password}")
    private String realPassword;

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (username.equals(realUsername) && password.equals(realPassword)) {
            StockSystemUser u = new StockSystemUser();
            u.setStocksystemuserPassword(password);
            u.setStocksystemuserName(username);
            return JWTUtils.getToken(u);
        }
        return "登录失败！账号或者密码不对！";
    }

    @GetMapping("test")
    public String test(HttpServletRequest request)  {
        // 测试了解析token中的字段
        String token = request.getHeader("token");
        System.out.println("Token 解析结果：" + JWT.decode(token).getClaim("userId").asString());
        return "访问test - API";
    }
}

