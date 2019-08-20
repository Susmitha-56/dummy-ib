package com.dbs.project.model;

import java.sql.Timestamp;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long referenceno;
	private long fromAccountNo;
	private long toAccountNo;
	private long amount;
	private String ifsc;
	private String date=LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	
	
	public Transaction() {

	}

	/*@JsonIgnore
	@JoinColumn(name = "bankaccountsid",nullable = false)
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	  private BankAccounts bankaccounts;*/
	
public Transaction(long fromAccountNo, long toAccountNo, long amount, String ifsc) {
	super();
	this.fromAccountNo = fromAccountNo;
	this.toAccountNo = toAccountNo;
	this.amount = amount;
	this.ifsc = ifsc;
		
}
	

}
