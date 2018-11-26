package com.ly.Controller;

import com.ly.bean.Employee;
import com.ly.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee putEmp(Employee employee) {
        return employeeService.putEmp(employee);
    }

    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id")Integer id) {
        employeeService.delEmp(id);
        return "success";
    }
}
