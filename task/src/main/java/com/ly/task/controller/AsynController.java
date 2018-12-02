package com.ly.task.controller;

import com.ly.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    private final AsyncService asyncService;

    @Autowired
    public AsynController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }


    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
