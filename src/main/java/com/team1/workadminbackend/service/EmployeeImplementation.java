package com.team1.workadminbackend.service;

import com.team1.workadminbackend.model.Employee;
import com.team1.workadminbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id){
        return employeeRepository.getReferenceById(id);
    }
}
