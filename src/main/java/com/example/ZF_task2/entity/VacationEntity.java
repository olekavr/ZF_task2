package com.example.ZF_task2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
public class VacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate vacationBegin;
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate vacationEnd;
    private Long registeredDays;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    public VacationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVacationBegin() {
        return vacationBegin;
    }

    public void setVacationBegin(LocalDate vacationBegin) {
        this.vacationBegin = vacationBegin;
    }

    public LocalDate getVacationEnd() {
        return vacationEnd;
    }

    public void setVacationEnd(LocalDate vacationEnd) {
        this.vacationEnd = vacationEnd;
    }

    public Long getRegisteredDays() { return registeredDays; }

    public void setRegisteredDays(Long registeredDays) {
        this.registeredDays = registeredDays;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
