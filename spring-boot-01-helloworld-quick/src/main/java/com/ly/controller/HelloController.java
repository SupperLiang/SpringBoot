package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiangYong
 * Date 2018/8/26
 * Time 10:02
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello Word!";
    }
}
