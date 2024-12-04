package com.sample.employee_service.mapper;

import com.sample.employee_service.dto.EmployeeDto;
import com.sample.employee_service.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee e) {
		EmployeeDto eDto = new EmployeeDto(
				e.getId(), 
				e.getFirstName(),
				e.getLastName(),
				e.getEmail(), 
				e.getDepartmentCode());
		return eDto;
	}
	
	public static Employee mapToEmployee(EmployeeDto e) {
		Employee emp = new Employee(
				e.getId(), 
				e.getFirstName(), 
				e.getLastName(), 
				e.getEmail(), 
				e.getDepartmentCode());
		return emp;
	}
}
