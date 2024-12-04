package com.sample.LoansApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoanAlreadyExistsException(String msg) {
		super(msg);
	}
}
