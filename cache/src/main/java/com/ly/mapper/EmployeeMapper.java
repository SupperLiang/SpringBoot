package com.ly.mapper;

import com.ly.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email} WHERE id = #{id}")
    void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{d_id})")
    void insertEmp(Employee employee);
}
