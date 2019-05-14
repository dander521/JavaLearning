package com.miaoshaproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"})
@MapperScan("com.miaoshaproject.dao")
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // 启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
