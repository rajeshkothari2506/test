package com.example.demo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public  class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	AccountRepository accRepo;
	
	@Test
	public void testSaveAccount() {
		
		Account account = new Account(101,"Saving Acc",1000000);
		when(accRepo.save(account)).thenReturn(account);
		assertEquals(101, accountService.saveAccount(account).getAccountID());
		
	}
	
	@Test
	public void testfindAccountByID() {
		Account account = new Account(101,"Saving Acc",1000000);
		
		when(accRepo.findById(101)).thenReturn(Optional.of(account));
		
		assertEquals(101, accountService.findAccountByID(101).getAccountID());
	}
	

}
