package com.dbs.project.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long referenceno;
	private long from_account_no;
	private long to_account_no;
	private long amount;
	private String ifsc;
	private String type;
	
	public Transaction() {

	}

	public Transaction(long from_account_no, long to_account_no, long amount, String type,String ifsc) {
		this.from_account_no = from_account_no;
		this.to_account_no = to_account_no;
		this.amount=amount;
		this.type=type;
		this.ifsc=ifsc;
		

	}
 
	

}
