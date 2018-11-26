package com.ly.service;

import com.ly.bean.Employee;
import com.ly.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp", key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id);
        return employeeMapper.getEmpById(id);
    }

    @CachePut(cacheNames = "emp", key = "#employee.id")
    public Employee putEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = "emp", key = "#id")
    public void delEmp(Integer id) {
        employeeMapper.deleteEmpById(id);
    }
}
