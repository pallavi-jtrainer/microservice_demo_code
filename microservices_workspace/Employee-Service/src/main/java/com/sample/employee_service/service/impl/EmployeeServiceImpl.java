package com.sample.employee_service.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.employee_service.dto.DepartmentDto;
import com.sample.employee_service.dto.EmployeeDto;
import com.sample.employee_service.dto.ResponseDto;
import com.sample.employee_service.entity.Employee;
import com.sample.employee_service.mapper.EmployeeMapper;
import com.sample.employee_service.repository.EmployeeRepository;
import com.sample.employee_service.service.APIClient;
import com.sample.employee_service.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private APIClient apiClient;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto e) {
		Employee emp = EmployeeMapper.mapToEmployee(e);
		Employee e1 = repo.save(emp);
		
		EmployeeDto eDto = EmployeeMapper.mapToEmployeeDto(e1);
		return eDto;
	}
	
	
	@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ResponseDto getEmployeeById(Long id) {
		ResponseDto response = new ResponseDto();
		//Optional<Employee> e = repo.findById(id);
		Employee e = repo.findById(id).get();
		EmployeeDto eDto = EmployeeMapper.mapToEmployeeDto(e);
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate
//				.getForEntity("http://localhost:8084/api/departments/" + e.getDepartmentCode(),
//				DepartmentDto.class);
//		
//		DepartmentDto deptDto = responseEntity.getBody();
		
		DepartmentDto deptDto = apiClient.getDepartment(e.getDepartmentCode());
		
		response.setEmployee(eDto);
		response.setDepartment(deptDto);
		return response;
	}

//	@Override
//	public Employee saveEmployee(Employee e) {
//		return repo.save(e);
//	}
	
	//fallback method
	public ResponseDto getDefaultDepartment(Long id, Exception ex) {
		Employee e = repo.findById(id).get();
		
		DepartmentDto deptDto = new DepartmentDto();
		deptDto.setDepartmentName("Learning and Development");
		deptDto.setDepartmentCode("LnD");
		
		EmployeeDto eDto = EmployeeMapper.mapToEmployeeDto(e);
		
		ResponseDto res = new ResponseDto();
		res.setEmployee(eDto);
		res.setDepartment(deptDto);
		
		return res;
	}

}
