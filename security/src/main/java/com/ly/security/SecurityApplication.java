package com.ly.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入SpringSecurity;
 * 2、编写SpringSecurity的配置类;
 *
 * @EnableWebSecurity extends WebSecurityConfigurerAdapter
 * <p>
 * 3、控制请求的访问权限
 */
@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
