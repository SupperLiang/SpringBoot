package com.ly.config;

import com.ly.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author LiangYong
 * Date 2018/8/26
 * Time 14:47
 */
@Configuration
// @ImportResource(locations = {"classpath:beans.xml"})
public class AppConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
