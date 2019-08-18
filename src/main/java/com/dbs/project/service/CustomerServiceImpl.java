package com.dbs.project.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;
import com.dbs.project.repository.CustomerRepository;
import com.dbs.project.repository.TransactionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	public TransactionRepository transactionRepository;
	
	


	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public List<Customer> listAll() {

		return this.customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(long cusid) {
		Optional<Customer> customer=customerRepository.findById(cusid);
		if(customer.isPresent())
		{
			return customer.get();
		}
		System.out.println("nullllll");
		return null;
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {

		return this.customerRepository.save(customer);
	}
	
	@Override
    @Transactional
    public Customer update(long id,Customer customer) {
		
    	customer = customerRepository.findById(id).get();
    	customer.setName(customer.getName());
    	customer.setUserName(customer.getUserName());
    	customer.setPassword(customer.getPassword());
    	customer.setPhoneNo(customer.getPhoneNo());
    	customer.setPAN(customer.getPAN());
    	customer.setAddress(customer.getAddress());
    	
    	return customerRepository.save(customer);
    	
    }

	@Override
	@Transactional
	public void deleteById(long id) {
		this.customerRepository.deleteById(id);
		
	}

	@Override
	public Customer findByUsername(String username) {
		
		return this.customerRepository.findByUserName(username).get();
	}

	@Override
	public Customer findByPassword(String password) {
	
		return this.customerRepository.findByPassword(password).get();

	}

	@Override
	public void saveTransaction(Transaction transaction) {
		 this.transactionRepository.save(transaction);
	}

	

}
