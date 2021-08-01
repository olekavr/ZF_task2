package com.example.ZF_task2.controller;

import com.example.ZF_task2.exception.EmployeeNotFoundException;
import com.example.ZF_task2.entity.EmployeeEntity;
import com.example.ZF_task2.model.Employee;
import com.example.ZF_task2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity registration(@RequestBody EmployeeEntity employee) {
        try {
            employeeService.registration(employee);
            return ResponseEntity.ok("Employee added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }

    }

    @GetMapping
    public ResponseEntity findEmployee(@RequestParam String firstName, String lastName) {
        try {
            List<Employee> employeeList;
            employeeList = employeeService.findEmployee(firstName, lastName);
            return ResponseEntity.ok(employeeList);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) {
        try {
            Employee employee;
            employee = employeeService.getEmployee(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }

    }
}
