package com.example.ZF_task2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatusMapper {

    private final Map<Integer, String> statusMap = new HashMap<>();

    public String getEmployeeStatus(Integer code) {
        if (code == 0) {
            return "PERFORMER";
        } else
            return "SLACKER";
    }
}
