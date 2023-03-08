package com.citi.stock.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 很重要！ https://blog.csdn.net/baidu_28068985/article/details/106659825
 * 工程经验少了
 */
@Configuration
@MapperScan(basePackages = "com.citi.stock.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml")
        );
        factoryBean.setTypeAliasesPackage("com.citi.stock.entity");
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}