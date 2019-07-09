package com.family.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.family.zhou.mapper.*")
public class ZhouApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhouApplication.class, args);
    }

}
