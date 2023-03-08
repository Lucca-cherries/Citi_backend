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
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private StockSystemUserMapper stockSystemUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws JwtException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new JwtException("interceptor: token不能为空");
        }
        try {
            String username = JWT.decode(request.getHeader("token")).getClaim("username").asString();
            String pwd = stockSystemUserMapper.findByUserName(username).getStocksystemuserPassword();
            JWTUtils.verify(token, pwd);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            throw new JwtException();
        } catch (TokenExpiredException e) {
            log.error("token过期！ 错误 ->", e);
            throw new JwtException();
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            throw new JwtException();
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            throw new JwtException();
        }
        return true;
    }
}

