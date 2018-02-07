package com.pengying.repository;

import com.pengying.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeJpaSpecificationExecutorRepository extends JpaSpecificationExecutor<Employee>,
        JpaRepository<Employee,Integer>{
}
