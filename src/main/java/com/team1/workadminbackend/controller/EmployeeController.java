package com.team1.workadminbackend.controller;

import com.team1.workadminbackend.model.Employee;
import com.team1.workadminbackend.service.EmployeeImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeImplementation employeeImplementation;

    @GetMapping("/employee-allocation")
    public Map<String, Object> employeeAllocation(@RequestBody Map<String, String> request) {

        Map<String, Object> response = new HashMap<String, Object>();

        Employee employee = employeeImplementation.getEmployeeById(Long.parseLong(request.get("employeeId")));
        Map<String, Object> employeeMap = new HashMap<String, Object>();

        employeeMap.put("name", employee.getName());
        employeeMap.put("id", employee.getId());
        employeeMap.put("location", employee.getLocation());
        employeeMap.put("expertise", employee.getExpertise());




        response.put("employee", employeeMap);
        return response;
    }
}
