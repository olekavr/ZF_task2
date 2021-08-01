package com.example.ZF_task2.model;

import com.example.ZF_task2.entity.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Long vacationDays;
    private String employeeStatus;
    private Long manager;
    private String email;
    private List<Vacation> vacationList;

    public static Employee toModel(EmployeeEntity entity) {
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setVacationDays(entity.getVacationDays());
        model.setManager(entity.getManager());
        model.setEmail(entity.getEmail());
        model.setVacationList(entity.getVacationList().stream().map(Vacation::toModel).collect(Collectors.toList()));
        return model;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Long vacationDays) {
        this.vacationDays = vacationDays;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vacation> getVacationList() {
        return vacationList;
    }

    public void setVacationList(List<Vacation> vacationList) {
        this.vacationList = vacationList;
    }

}
