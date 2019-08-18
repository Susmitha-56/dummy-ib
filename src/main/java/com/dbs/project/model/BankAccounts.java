package com.dbs.project.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class BankAccounts implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bankaccountsid")
	private long id;
	private long acnumber;
	private double balance;
	private String branch;
	private String ifsc;
	
	public BankAccounts()
	{
		
	}
	public BankAccounts(long id,long acnumber, double balance, String branch, String ifsc) {
		this.id=id;
		this.acnumber = acnumber;
		this.balance = balance;
		this.branch = branch;
		this.ifsc = ifsc;
		
	}
	
	@JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY,optional = false)
	// @JoinColumn(name = "custid",nullable = false)
	  private Customer customer;
	
	
	// @OneToMany(mappedBy = "account", fetch = FetchType.LAZY) private
	//  Set<Transaction> transaction=new HashSet<>();
	 
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccounts other = (BankAccounts) obj;
		if (acnumber != other.acnumber)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (acnumber ^ (acnumber >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	

	
	
	
	/*
	  public Set<Transaction> getTransactions() 
	  { 
		  return transactions; 
	  }
	  
	  public void setOperations(Collection<Transactions> operations) {
	  this.transactions = transactions; }*/
	 
	
	
}
