package com.sample.LoansApp.exceptions;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.LoansApp.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			WebRequest req, 
			HttpHeaders headers,
			HttpStatusCode code) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		
		errorList.forEach((error) -> {
			String errField = ((FieldError) error).getField();
			String errMsg = error.getDefaultMessage();
			
			validationErrors.put(errField, errMsg);
		});
		
		return new ResponseEntity<Object>(validationErrors, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(
			Exception ex,
			WebRequest req) {
		ErrorResponseDto response = new ErrorResponseDto(
				req.getDescription(false), 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				ex.getMessage(), 
				LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(LoanAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleLoanAlreadyExistsException(
			Exception ex,
			WebRequest req) {
		ErrorResponseDto response = new ErrorResponseDto(
				req.getDescription(false), 
				HttpStatus.BAD_REQUEST, 
				ex.getMessage(), 
				LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
