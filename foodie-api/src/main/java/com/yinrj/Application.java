package com.yinrj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
@ComponentScan("com.yinrj.")
@SpringBootApplication
@MapperScan(basePackages = "com.yinrj")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
