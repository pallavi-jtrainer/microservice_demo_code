package com.sample.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {
	private Long id;
    private String departmentName;
    private String departmentCode;
}
