package com.sample.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sample.employee_service.dto.DepartmentDto;

@FeignClient(value="DEPARTMENT-SERVICE", url="http://localhost:8084")
public interface APIClient {
	
	@GetMapping("api/departments/{code}")
	public DepartmentDto getDepartment(@PathVariable String code);
}
