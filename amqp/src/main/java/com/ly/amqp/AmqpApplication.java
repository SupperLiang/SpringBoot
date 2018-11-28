package com.ly.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、   RabbitAutoConfiguration
 * 2、   有自动配置了连舍工厂ConnecHonFoctory;
 * 3、   RabbitProperties封装了 RobtiitWQ的配置
 * 4、       RabbitTemplate:给RabbitMQ发送和受消息；
 * 5、       AmqpAdmin	:RobfciitMG系统管理功能组件
 * 6、   @EnableRabbit+  @RabbitListener 监听消息队列的内容
 */
@EnableRabbit
@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }
}
