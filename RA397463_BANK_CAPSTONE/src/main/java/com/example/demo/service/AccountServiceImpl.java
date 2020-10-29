package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account findAccountByID(int id) throws AccountNotFoundException {
		Optional<Account> account = accountRepo.findById(id);
		if (!account.isPresent()) {
			throw new AccountNotFoundException("Account Not Found for Account ID "+id);
		}

		return account.get();
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	
	
}
