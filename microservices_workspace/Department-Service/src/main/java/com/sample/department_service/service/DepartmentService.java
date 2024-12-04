package com.sample.department_service.service;

import com.sample.department_service.dto.DepartmentDto;

public interface DepartmentService {
	public DepartmentDto saveDepartment(DepartmentDto dept);
	public DepartmentDto getDepartmentByCode(String code);
}
