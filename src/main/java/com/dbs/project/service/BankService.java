package com.dbs.project.service;

import java.util.List;

import com.dbs.project.model.Bank;

public interface BankService {
	
	Bank findByUsername(String username);

	List<Bank> listAll();
	
	Bank findById(long empid);
	

}
