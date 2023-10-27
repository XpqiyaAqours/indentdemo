package com.indent.indentdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.indent.indentdemo.*.mapper")
public class IndentdemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IndentdemoApplication.class, args);
    }
    //外部Tomcat启动需要使用方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IndentdemoApplication.class);
    }

}
