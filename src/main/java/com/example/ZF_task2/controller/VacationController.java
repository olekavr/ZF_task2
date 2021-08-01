package com.example.ZF_task2.controller;

import com.example.ZF_task2.entity.VacationEntity;
import com.example.ZF_task2.exception.EmployeeNotFoundException;
import com.example.ZF_task2.model.Vacation;
import com.example.ZF_task2.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @PostMapping
    public ResponseEntity registration(@RequestBody VacationEntity vacation,
                                       @RequestParam Long employeeId) {
        try {
            vacationService.registration(vacation, employeeId);
            return ResponseEntity.ok("Vacation added");
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping
    public ResponseEntity findVacation(@RequestParam Long employeeId) {
        try {
            List<Vacation> vacationList;
            vacationList = vacationService.findVacation(employeeId);
            return ResponseEntity.ok(vacationList);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

}
