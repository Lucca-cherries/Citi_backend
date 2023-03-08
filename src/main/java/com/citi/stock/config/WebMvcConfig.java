package com.citi.stock.config;

import com.citi.stock.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 很重要
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public JWTInterceptor getJwtFilter() {
        return new JWTInterceptor();
    }

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getJwtFilter()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getJwtFilter()) // 这里必须要用get不能用new，否则会出之前null的问题
//                //拦截的路径，注意一定要合理设置拦截器
//                .addPathPatterns("/api/users/*") // 注销用户
//                .addPathPatterns("/api/favorites")
//                .addPathPatterns("/api/stocks")
                //排除接口
                .excludePathPatterns("/api/stocks")
                .excludePathPatterns("/api/users/reg")
                .excludePathPatterns("/api/users/login");
    }

}