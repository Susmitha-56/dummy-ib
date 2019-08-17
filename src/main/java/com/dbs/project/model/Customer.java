package com.dbs.project.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Customer implements Serializable, Comparable<Customer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cusid")
	private long cid;

	@Column(name = "customerName", nullable = false)
	private String name;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "pan", nullable = false)
	private String PAN;

	@Column(name = "phoneNo", nullable = false)
	private int phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BankAccounts> bankAccountsSet = new HashSet<>();

	/*@ManyToOne
	@JoinColumn(name = "empid", nullable = false)
	private Bank bank;*/
	
	public void addBankAccounts(BankAccounts account)
	{
		this.bankAccountsSet.add(account);
		account.setCustomer(this);
	}

	public Customer() {
	
	}
	public Customer(String name, String userName, String password, String PAN, int phoneNo) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.PAN = PAN;
		this.phoneNo = phoneNo;
	}

	

	@Override
	public int compareTo(Customer customer) {
		return (int) (this.cid - customer.cid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (PAN == null) {
			if (other.PAN != null)
				return false;
		} else if (!PAN.equals(other.PAN))
			return false;
		if (bankAccountsSet == null) {
			if (other.bankAccountsSet != null)
				return false;
		} else if (!bankAccountsSet.equals(other.bankAccountsSet))
			return false;
		if (cid != other.cid)
			return false;
		
		if (phoneNo != other.phoneNo)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
	
}
