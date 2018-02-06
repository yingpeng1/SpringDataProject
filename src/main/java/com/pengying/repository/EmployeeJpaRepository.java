package com.pengying.repository;

import com.pengying.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>{
}
