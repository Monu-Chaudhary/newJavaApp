package com.department.service.impl;

import com.department.entity.Department;
import com.department.repositories.DepartmentRepository;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Integer id) {
        return this.departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> getAllDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Integer id) {
        Department d = this.departmentRepository.findById(id).get();
        this.departmentRepository.delete(d);
    }

    @Override
    public Department updateDepartment(Department d, Integer id) {
        Department d1 = new Department();
        d1.setDepartmentCode(d.getDepartmentCode());
        d1.setDepartmentName(d.getDepartmentName());
        d1.setDepartmentDescription(d.getDepartmentDescription());
        return this.departmentRepository.save(d1);
    }

}
