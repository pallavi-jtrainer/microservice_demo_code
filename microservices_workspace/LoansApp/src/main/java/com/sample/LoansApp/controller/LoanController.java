package com.sample.LoansApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.LoansApp.constants.LoanConstants;
import com.sample.LoansApp.dto.ResponseDto;
import com.sample.LoansApp.entity.Loans;
import com.sample.LoansApp.exceptions.LoanAlreadyExistsException;
import com.sample.LoansApp.service.LoansService;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/loans")
@Validated
public class LoanController {

	@Autowired
	private LoansService service;
	
//	@PostMapping("/create")
//	public ResponseEntity<Loans> createLoan(@RequestParam
//			@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
//			String mobile) 
//					throws LoanAlreadyExistsException {
//		Loans loan = service.createLoan(mobile);
//		
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(loan);
//	}
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createLoan(@RequestParam
			@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
			String mobile) 
					throws LoanAlreadyExistsException {
		service.createLoan(mobile);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
	}
}
