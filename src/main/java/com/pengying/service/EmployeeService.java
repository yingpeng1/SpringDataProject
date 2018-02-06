package com.pengying.service;

import com.pengying.domain.Employee;
import com.pengying.repository.EmployeeCrudRepository;
import com.pengying.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }
}
