package com.sample.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.department_service.dto.DepartmentDto;
//import com.sample.department_service.entity.Department;
import com.sample.department_service.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code) {
		DepartmentDto dept = service.getDepartmentByCode(code);
		return new ResponseEntity<>(dept, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto dept){
		DepartmentDto savedDept = service.saveDepartment(dept);
		return new ResponseEntity<>(savedDept, HttpStatus.OK);
	}
}
