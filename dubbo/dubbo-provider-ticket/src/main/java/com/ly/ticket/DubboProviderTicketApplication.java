package com.ly.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务的提供者注册到服务中心
 * 1、引入dubbo和zkclient相关依赖
 * 2、配置dubbo的扫描包和注册中心
 * 3、使用@Service发布服务（com.alibaba.dubbo.config.annotation.Service ）
 */
@SpringBootApplication
public class DubboProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderTicketApplication.class, args);
    }
}
