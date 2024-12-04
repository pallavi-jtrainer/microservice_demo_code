package com.sample.LoansApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.LoansApp.entity.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long>{
	public Optional<Loans> findByMobileNumber(String mobileNumber);
	public Loans findByLoanNumber(String loanNumber);
	
}
