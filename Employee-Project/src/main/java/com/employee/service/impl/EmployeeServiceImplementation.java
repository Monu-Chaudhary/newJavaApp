package com.employee.service.impl;

import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.ResponseDto;
import com.employee.entity.Employee;
import com.employee.repositories.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public ResponseDto getEmployee(Integer id) {
        Employee employee = this.employeeRepository.findById(id).get();
        EmployeeDto employeeDto = mapEmployeeToDto(employee);
        int departmentId = employee.getDepartmentId();

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/department/get/" + departmentId, DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        System.out.println("Status CODE::" + responseEntity.getStatusCode());

        return new ResponseDto(departmentDto, employeeDto);
    }

    private EmployeeDto mapEmployeeToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setFirstName(employee.getFirstName());
        return employeeDto;
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
