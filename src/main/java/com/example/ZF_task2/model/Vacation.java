package com.example.ZF_task2.model;

import com.example.ZF_task2.entity.VacationEntity;

import java.time.LocalDate;

public class Vacation {
    private Long id;
    private LocalDate vacationBegin;
    private LocalDate vacationEnd;
    private Long registeredDays;

    public static Vacation toModel(VacationEntity entity) {
        Vacation model = new Vacation();
        model.setId(entity.getId());
        model.setVacationBegin(entity.getVacationBegin());
        model.setVacationEnd(entity.getVacationEnd());
        model.setRegisteredDays(entity.getRegisteredDays());
        return model;
    }

    public Vacation() {
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

    public Long getRegisteredDays() {
        return registeredDays;
    }

    public void setRegisteredDays(Long registeredDays) {
        this.registeredDays = registeredDays;
    }
}
