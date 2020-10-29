package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accService;

	@GetMapping("/allAccount")
	public List<Account> getAllAccount() {

		return accService.getAllAccounts();

	}

	@GetMapping("/findAccount/{id}")
	public Account getAcccountByID(@PathVariable int id) {

		return accService.findAccountByID(id);
	}
	
	
	
}
