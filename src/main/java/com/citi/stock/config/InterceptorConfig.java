package com.citi.stock.config;

import com.citi.stock.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author admin
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //拦截的路径，注意一定要合理设置拦截器
                .addPathPatterns("/api/users/*") // 注销用户
                .addPathPatterns("/api/favorites")
                //排除接口
                .excludePathPatterns("/api/users")
                .excludePathPatterns("/api/users/login");
    }
}

