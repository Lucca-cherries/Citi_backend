package com.citi.stock.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.citi.stock.entity.StockSystemUser;
import com.citi.stock.interceptor.ex.JwtException;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * @author admin
 */
public class JWTUtils {

    /**
     * 获取token
     * @param u user
     * @return token
     */
    public static String getToken(StockSystemUser u) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间1天
        instance.add(Calendar.DATE, 1);

        JWTCreator.Builder builder = JWT.create();
//        System.err.println("encode: " + u.getStocksystemuserId());
        builder.withClaim("userId", u.getStocksystemuserId())
                .withClaim("username", u.getStocksystemuserName());

        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(u.getStocksystemuserPassword()));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token, String password) throws JwtException {
        if(StringUtils.isEmpty(token)){
            throw new JwtException("utils: token不能为空");
        }

        //登录用户真正的密码
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }

}

