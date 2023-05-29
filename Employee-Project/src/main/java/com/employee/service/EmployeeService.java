package com.employee.service;

import com.employee.dto.ResponseDto;
import com.employee.entity.Employee;
import java.util.*;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    ResponseDto getEmployee(Integer id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    Employee updateEmployee(Employee e, Integer id);
}
