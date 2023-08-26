package com.zisheng;

import com.zisheng.Mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({com.YYDS.mapper.UserMapper.class})
public class MybatisPlus01QuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus01QuickStartApplication.class, args);
    }

}
