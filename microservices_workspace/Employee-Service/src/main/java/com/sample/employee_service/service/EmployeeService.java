package com.sample.employee_service.service;

import com.sample.employee_service.dto.EmployeeDto;
import com.sample.employee_service.dto.ResponseDto;
import com.sample.employee_service.entity.Employee;

public interface EmployeeService {
	public EmployeeDto saveEmployee(EmployeeDto e);
//	public Employee saveEmployee(Employee e);
	public ResponseDto getEmployeeById(Long id);
}
