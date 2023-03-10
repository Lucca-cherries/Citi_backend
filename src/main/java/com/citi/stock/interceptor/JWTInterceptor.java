package com.citi.stock.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.citi.stock.mapper.StockSystemUserMapper;
import com.citi.stock.util.JWTUtils;
import com.citi.stock.interceptor.ex.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author admin
 * 拦截器，请求到达controller之前会先执行preHandler
 * 可能会出现mapper无法实例化的问题，因为拦截器在springboot项目创建之前实例化
 * 详见两个配置类
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private StockSystemUserMapper stockSystemUserMapper;

    @Override
    // 如果接口被拦截，控制层接受请求之前会执行这个函数
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws JwtException, TokenExpiredException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            log.error("Token is empty in interceptor.");
            throw new JwtException("interceptor: Token can not be empty.");
        }
        try {
            String username = JWT.decode(request.getHeader("token")).getClaim("username").asString();
            log.info("User {} is verifying the token.", username);
            String pwd = stockSystemUserMapper.findByUserName(username).getStocksystemuserPassword();
            JWTUtils.verify(token, pwd);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            throw new JwtException("Invalid token.");
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            throw new JwtException("Token algorithm inconsistent.");
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            throw new JwtException("Token invalid.");
        }
        return true;
    }
}

