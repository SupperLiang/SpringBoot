package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiangYong
 * Date 2018/8/26
 * Time 9:52
 */

/*  @SpringBootApplication 来标识一个主程序类，说明这是一个spring boot 应用 */
@SpringBootApplication
public class HelloWordMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWordMainApplication.class);
    }
}
