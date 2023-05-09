package com.department.service;

import com.department.entity.Department;
import java.util.*;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartment(Integer id);
    List<Department>  getAllDepartments();
    void deleteDepartment(Integer id);
    Department updateDepartment(Department d, Integer id);
}
