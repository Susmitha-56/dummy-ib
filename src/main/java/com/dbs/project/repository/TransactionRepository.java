package com.dbs.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.project.model.Transaction;
import com.dbs.project.model.*;
@Repository

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	 Optional<Transaction> findByReferenceno(long reference_no);
	 
	List<Transaction> findAll();
	//void save(Transaction transaction);
	

}
