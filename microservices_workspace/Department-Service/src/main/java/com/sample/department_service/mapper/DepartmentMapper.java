package com.sample.department_service.mapper;

import com.sample.department_service.dto.DepartmentDto;
import com.sample.department_service.entity.Department;

public class DepartmentMapper {
	public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
