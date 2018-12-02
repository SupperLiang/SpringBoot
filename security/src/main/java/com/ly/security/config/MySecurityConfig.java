package com.ly.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启登录功能
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        //1、/login请求来的登陆页，如果没用权限就还到登录页面
        //2、重定向到/login?error表示登录失败
        //3、更多详情规则
        //4、默认post形式的 /login代表处理登录
        //5、一但定制loginPage那么loginPage的post请求就是登陆


        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");//注销成功以后来的首页
        //1、访问 /login 表示用户注销，情况session
        //2、注销成功会返回 /login?logout

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 定制请求的认证规则
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("VIP1", "VIP2")
                .and()
                .withUser("root").password("root").roles("VIP3").and().passwordEncoder(new CustomPasswordEncoder());

    }
}
