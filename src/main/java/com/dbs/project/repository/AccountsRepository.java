package com.dbs.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.project.model.BankAccounts;

public interface AccountsRepository extends JpaRepository<BankAccounts, Long> {

	

}