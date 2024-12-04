package com.sample.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.employee_service.dto.EmployeeDto;
import com.sample.employee_service.dto.ResponseDto;
import com.sample.employee_service.entity.Employee;
import com.sample.employee_service.mapper.EmployeeMapper;
import com.sample.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
		EmployeeDto eDto = EmployeeMapper.mapToEmployeeDto(e);
		
		eDto = service.saveEmployee(eDto);
		
		Employee emp = EmployeeMapper.mapToEmployee(eDto);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> getEmployeeDetails(@PathVariable("id") Long id) {
		ResponseDto res = service.getEmployeeById(id);
		return ResponseEntity.ok(res);
	}
}
