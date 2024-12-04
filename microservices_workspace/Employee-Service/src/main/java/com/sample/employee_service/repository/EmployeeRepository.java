package com.sample.employee_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.employee_service.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Optional<Employee> findByEmail(String email);
	public List<Employee> findAllByDepartmentCode(String code);
}
