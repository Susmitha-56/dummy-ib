package com.dbs.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbs.project.model.BankAccounts;
import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;
import com.dbs.project.service.BankAccountsService;
import com.dbs.project.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController

@RequestMapping("/xyz")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	BankAccountsService bankaccountsservice;
	
	@GetMapping("/cus-details")
	public List<Customer> listAllCustomers(){
		return customerService.listAll();
	}
	@GetMapping("/login")
	public String login(){
		return "login";
		
	}
	@PostMapping("/login")
	public Set<BankAccounts> loginpost(
		  @RequestParam("username") String username,
          @RequestParam("password") String password)
		{
				Set<BankAccounts> s=new HashSet<>();
				Customer c1=customerService.findByUsername(username);
				
				Customer c2=customerService.findByPassword(password);
		     
		      if(customerService.findByUsername(username)!= null && customerService.findByPassword(password)!=null&& (c1.getPassword()==c2.getPassword())) {
		      	
		    	  s=this.customerService.findById(c1.getCid()).getBankAccountsSet();
		    	  return s;
		      }
		      else
		      return s;
		}
	
	@GetMapping("/customers/{id}/accounts")
    public Set<BankAccounts> getCustomerAccount(@PathVariable long id){
		
		return this.customerService.findById(id).getBankAccountsSet();
		
    }
	
	@PutMapping("/cus-fetch-id/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id,
			@Valid @RequestBody Customer customer) {
		return customerService.update(id, customer);
	}
	
	@DeleteMapping("/cus-delete/{id}")
	public void deleteById(@PathVariable("id") Long id){
		 customerService.deleteById(id);
	}
	
	@PostMapping("/transactions")
	public Transaction fundTransfer(@RequestBody Transaction transaction)
	{

	
		
		long fromacc=transaction.getFromAccountNo();
		long toacc=transaction.getToAccountNo();
		BankAccounts ba1=bankaccountsservice.findByAcNumber(fromacc);
		BankAccounts ba2=bankaccountsservice.findByAcNumber(toacc);
		double enteredAmount=transaction.getAmount();
		double amount1=ba1.getBalance()-enteredAmount;
		double amount2=ba2.getBalance()+enteredAmount;
		ba1.setBalance(amount1);
		ba2.setBalance(amount2);
		System.out.println(ba1.getBalance());
		return this.customerService.saveTransaction(transaction);
	}


 
}
