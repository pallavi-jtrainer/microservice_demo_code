package com.sample.department_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.department_service.dto.DepartmentDto;
import com.sample.department_service.entity.Department;
import com.sample.department_service.mapper.DepartmentMapper;
import com.sample.department_service.repository.DepartmentRepository;
import com.sample.department_service.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		 Department department = DepartmentMapper.mapToDepartment(departmentDto);
         Department savedDepartment = repo.save(department);
         DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

         return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department department = repo.findByDepartmentCode(code);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
	}

}
