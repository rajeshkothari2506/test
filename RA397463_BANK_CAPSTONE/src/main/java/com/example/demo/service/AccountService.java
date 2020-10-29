package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Account;

public interface AccountService {
	
	public Account saveAccount(Account account);
	Account findAccountByID(int id);
	public List<Account> getAllAccounts();
	
}
