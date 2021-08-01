package com.example.ZF_task2.service;

import com.example.ZF_task2.exception.EmployeeNotFoundException;
import com.example.ZF_task2.entity.EmployeeEntity;
import com.example.ZF_task2.model.Employee;
import com.example.ZF_task2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusMapper statusMapper;

    public EmployeeEntity registration(EmployeeEntity employee) {

        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        List<EmployeeEntity> employeeEntityList;

        employeeEntityList = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (employeeEntityList.size() == 0) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        List<Employee> employeeList = new ArrayList<>();

        for (EmployeeEntity employeeEntity: employeeEntityList) {
            Employee employee = Employee.toModel(employeeEntity);
            employee.setEmployeeStatus(statusMapper.getEmployeeStatus(employeeRepository.checkStatus(employee.getId())));
            employeeList.add(employee);
            
        }

        return employeeList;
    }

    public Employee getEmployee(Long id) throws EmployeeNotFoundException {
        EmployeeEntity employeeEntity;

        try {
            employeeEntity = employeeRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        Employee employee = Employee.toModel(employeeEntity);
        employee.setEmployeeStatus(statusMapper.getEmployeeStatus(employeeRepository.checkStatus(employee.getId())));

        return employee;
    }
}
