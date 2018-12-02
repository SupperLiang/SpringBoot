package com.ly.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入dubbo和zkclient相关依赖
 * 2、配置dubbo注册中心
 * 3、引用服务
 */
@SpringBootApplication
public class DubboConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerUserApplication.class, args);
    }
}
