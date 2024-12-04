package com.sample.LoansApp.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.LoansApp.constants.LoanConstants;
import com.sample.LoansApp.entity.Loans;
import com.sample.LoansApp.exceptions.LoanAlreadyExistsException;
import com.sample.LoansApp.repository.LoansRepository;

@Service
public class LoansService {

	@Autowired
	private LoansRepository repo;
	
	private Loans createNewLoan(String mobile) {
		Loans newLoan = new Loans();
		long randomNumber = 1000000000000L + new Random().nextInt(900000000);
		newLoan.setLoanNumber(Long.toString(randomNumber));
		newLoan.setMobileNumber(mobile);
		newLoan.setLoanType(LoanConstants.HOME_LOAN);
		newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
		newLoan.setAmountPaid(0);
		newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
		
		return newLoan;
	}
	
	public Loans createLoan(String mobile) throws LoanAlreadyExistsException {
		Optional<Loans> existingLoan = repo.findByMobileNumber(mobile);
		
		if(existingLoan.isPresent()) {
			throw new LoanAlreadyExistsException("Loan already registered for the given mobile number: " + mobile);
		}
		
		return repo.save(createNewLoan(mobile));
	}
}
