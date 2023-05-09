package com.employee.service.impl;

import com.employee.entity.Employee;
import com.employee.repositories.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee e = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(e);
    }

    @Override
    public Employee updateEmployee(Employee e, Integer id) {
        Employee e1 = new Employee();
        e1.setEmail(e.getEmail());
        e1.setPassword(e.getPassword());
        e1.setFirstName(e.getFirstName());
        e1.setLastName(e.getLastName());
        return this.employeeRepository.save(e1);
    }
}
