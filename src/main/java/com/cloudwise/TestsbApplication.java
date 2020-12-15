package com.cloudwise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cloudwise.dao")
public class TestsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestsbApplication.class, args);
    }

}
