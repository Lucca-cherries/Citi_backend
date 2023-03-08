package com.citi.stock;

import com.citi.stock.mapper.StockSystemUserMapper;
import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.citi.stock")
public class StockApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(StockApplication.class, args);
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private StockSystemUserMapper stockSystemUserMapper;

    @Override
    public void run(String... args) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
    }
}
