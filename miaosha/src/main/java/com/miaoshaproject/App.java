package com.miaoshaproject;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataObject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"})
@MapperScan("com.miaoshaproject.dao")
@RestController
public class App
{
    @Autowired
    UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home() {
        UserDO userDO = userDOMapper.selectByPrimaryKey("1558062771294");
        if(userDO == null) {
            return "用户对象不存在";
        } else {
            return userDO.getName();
        }

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // 启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
