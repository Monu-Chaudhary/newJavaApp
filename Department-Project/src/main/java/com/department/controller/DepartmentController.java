package com.department.controller;

import com.department.entity.Department;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/add")
    public ResponseEntity<Department> pushDepartment(@RequestBody Department department) {
        Department d = this.departmentService.saveDepartment(department);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Integer id) {
        Department d1 = this.departmentService.getDepartment(id);
        return new ResponseEntity<>(d1, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = this.departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department d, @PathVariable("id") Integer id) {
        Department d2 = this.departmentService.updateDepartment(d, id);
        return new ResponseEntity<>(d2, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable("id") Integer id) {
        this.departmentService.deleteDepartment(id);
    }
}
