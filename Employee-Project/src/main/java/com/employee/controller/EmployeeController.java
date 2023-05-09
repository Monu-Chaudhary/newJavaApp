package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee e = this.employeeService.saveEmployee(employee);
        return  new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
        Employee e1 = this.employeeService.getEmployee(id);
        return new ResponseEntity<>(e1, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> e = this.employeeService.getAllEmployees();
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e, @PathVariable("id") Integer id) {
        Employee e1 = this.employeeService.updateEmployee(e, id);
        return new ResponseEntity<>(e1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {
        this.employeeService.deleteEmployee(id);
    }

}
