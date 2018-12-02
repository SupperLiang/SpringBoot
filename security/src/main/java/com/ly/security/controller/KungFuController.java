package com.ly.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KungfuController {
    private String prefix = "pages/";

    /**
     * 欢迎页
     *
     * @return 返回页面
     */
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    /**
     * 登陆页
     *
     * @return 返回页面
     */
    @GetMapping("/userlogin")
    public String loginPage() {
        return prefix + "login";
    }


    /**
     * level1页面映射
     *
     * @param path 请求参数
     * @return 返回页面
     */
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return prefix + "level1/" + path;
    }

    /**
     * level2页面映射
     *
     * @param path 请求参数
     * @return 返回页面
     */
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return prefix + "level2/" + path;
    }

    /**
     * level3页面映射
     *
     * @param path 请求参数
     * @return 返回页面
     */
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return prefix + "level3/" + path;
    }


}
