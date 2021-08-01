package com.example.ZF_task2.service;

import com.example.ZF_task2.entity.EmployeeEntity;
import com.example.ZF_task2.entity.VacationEntity;
import com.example.ZF_task2.exception.EmployeeNotFoundException;
import com.example.ZF_task2.model.Vacation;
import com.example.ZF_task2.repository.EmployeeRepository;
import com.example.ZF_task2.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusMapper statusMapper;

    public VacationEntity registration(VacationEntity vacation, Long employeeId) throws EmployeeNotFoundException {
        EmployeeEntity employee;
        SendMailService sendMailService = new SendMailService(vacation);

        try {
            employee = employeeRepository.findById(employeeId).get();
        }  catch (NoSuchElementException e) {
        throw new EmployeeNotFoundException("Employee Not Found");
    }
        vacation.setEmployee(employee);

        Long daysAvailable = employee.getVacationDays();
        Long daysToRegistered = DAYS.between(vacation.getVacationBegin(), vacation.getVacationEnd());
        Long registeredDays = vacationRepository.registeredDays(employeeId);
        String employeeStatus = statusMapper.getEmployeeStatus(employeeRepository.checkStatus(employeeId));

        if (daysAvailable < daysToRegistered + registeredDays) {
            if (employeeStatus.equals("PERFORMER")) {
                vacation.setEmployee(employee);
                vacation.setRegisteredDays(daysToRegistered);
                sendMailService.sendMail(employeeRepository.findById(employee.getManager()).get().getEmail());
                return vacationRepository.save(vacation);
            } else {
                throw new EmployeeNotFoundException("The vacation cannot be registered");
            }
        } else {
            if (employeeStatus.equals("SLACKER")) {
                throw new EmployeeNotFoundException("The vacation cannot be registered");
            } else {
                vacation.setEmployee(employee);
                vacation.setRegisteredDays(daysToRegistered);
                sendMailService.sendMail(employeeRepository.findById(employee.getManager()).get().getEmail());
                return vacationRepository.save(vacation);
            }
        }
    }

    public List<Vacation> findVacation(Long employeeId) throws EmployeeNotFoundException {
        List<VacationEntity> vacationEntityList;

        vacationEntityList = vacationRepository.findByEmployeeId(employeeId);

        if (vacationEntityList.size() == 0) {
            throw new EmployeeNotFoundException("Vacations Not Found");
        }

        List<Vacation> vacationList = new ArrayList<>();

        for (VacationEntity vacationEntity: vacationEntityList) {
            vacationList.add(Vacation.toModel(vacationEntity));

        }

        return vacationList;
    }
}
