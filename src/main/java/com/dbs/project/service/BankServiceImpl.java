package com.dbs.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.project.model.Bank;
import com.dbs.project.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	@Transactional
	public Bank findByUsername(String username) {
		return this.bankRepository.findByUsername(username).get();
	}


	@Override
	@Transactional
	public List<Bank> listAll() {
		return this.bankRepository.findAll();
	}

	@Override
	@Transactional
	public Bank findById(long empid) {
		return this.bankRepository.findById(empid).get();
	}
}
