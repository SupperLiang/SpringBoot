package com.ly.controller;

import com.ly.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * @author LiangYong
 * Date 2018/9/16
 * Time 12:40
 */
@Controller
public class HelloController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HelloWord";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("value1", "你好");
        map.put("value2", "<h2>你好</h2>");
        map.put("value3", Arrays.asList("1", "2", "3", "4", "5"));
        return "success";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        } else {
            map.put("msg", "用户名密码错误");
            return "index";
        }
    }

    @GetMapping(value = "/emps")
    public String empsList(Map<String, Object> map) {
        map.put("emps", employeeDao.getAll());
        return "emp/list";
    }
}
