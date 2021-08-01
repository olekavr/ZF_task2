package com.example.ZF_task2.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Long vacationDays;
    private Long manager;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<VacationEntity> vacationList;
    @UpdateTimestamp
    private LocalDateTime updateTs;

    public EmployeeEntity() {
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

    public List<VacationEntity> getVacationList() {
        return vacationList;
    }

    public void setVacationList(List<VacationEntity> vacationList) {
        this.vacationList = vacationList;
    }

    public LocalDateTime getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(LocalDateTime updateTs) {
        this.updateTs = updateTs;
    }
}
