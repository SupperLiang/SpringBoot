package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiangYong
 * Date 2018/8/26
 * Time 10:02
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "Hello Word!";
    }
}
