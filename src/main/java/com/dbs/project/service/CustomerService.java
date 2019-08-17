package com.dbs.project.service;

import java.util.List;


import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;

public interface CustomerService {
	
	List<Customer> listAll();
	
	Customer findById(long cusid);
	Customer findByUsername(String username);
	Customer findByPassword(String password);
	Customer save(Customer customer);
	void deleteById(long id);
  
	Customer update(long id, Customer customer);
	void saveTransaction(Transaction transaction);
		
}
