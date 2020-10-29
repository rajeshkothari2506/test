package com.example.demo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


@RunWith(MockitoJUnitRunner.class)

public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerService;

	@Mock
	CustomerRepository customerRepo;
	
	@Mock
	AccountService accountService;
	
	/*
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void testSaveCustomer() {
		Customer customer = new Customer();
		customer.setAccountInfromation(null);
		customer.setCustomerAddress("Wipro Hinjewadi");
		customer.setCustomerName("Dummy Customer");
		customer.setId(101);
		customerService.saveCustomer(customer);
		
		verify(customerRepo,times(1)).save(customer);
	}
	
	@Test
	public void testfindCustomerByID() {
		//Customer customer = new Customer();
		Customer customer = new Customer();
		customer.setAccountInfromation(null);
		customer.setCustomerAddress("Wipro Hinjewadi");
		customer.setCustomerName("Dummy Customer");
		customer.setId(10);
		
		when(customerRepo.findById(1)).thenReturn(Optional.of(customer));
		
		assertEquals(1, customerService.findCustomerByID(1).getId());
	}
	
	@Test
	public void testgetAllCustomer() {
		List list = new ArrayList();
		//list.
		list.add(new Account(100,"current",10000));		
		Customer c1 = new Customer("c1","Gandhi Nagar",list);
		Customer c2 = new Customer("c2","Surat",null);
		List<Customer> listOfCustomer = new ArrayList();
		listOfCustomer.add(c1);
		listOfCustomer.add(c2);
		when(customerRepo.findAll()).thenReturn(listOfCustomer);		
		assertEquals(2, customerService.getAllCustomer().size());
		
	}
	
	@Test
	public void testupdateCustomerInformation() {
		
		List list = new ArrayList();
		//list.
		list.add(new Account(100,"current",10000));		
		Customer c1 = new Customer("c1","Gandhi Nagar",list);
		c1.setId(1);
		when(customerRepo.save(c1)).thenReturn(c1);
		when(customerRepo.findById(1)).thenReturn(Optional.of(c1));
		assertEquals("Gandhi Nagar", customerService.updateCustomerInformation(c1).getCustomerAddress());
	}
	
	@Test
	
	public void  testDeleteCustomerById() {
		List list = new ArrayList();
		
		list.add(new Account(100,"current",10000));		
		Customer c1 = new Customer("c1","Gandhi Nagar",list);
		c1.setId(1);
		//when(customerRepo.deleteById(id;
		when(customerRepo.findById(1)).thenReturn(Optional.of(c1));
		
		customerService.deleteCustomerByID(1);
		
		
	}
	
	@Test
	public void testFundTransferOfCustomer()
	{
		Account account = new Account(101,"Current Account",10000);
		Account account2 = new Account(102,"SVING Account",5000);
		when(accountService.findAccountByID(105)).thenReturn(account);
		when(accountService.findAccountByID(102)).thenReturn(account2);
		assertEquals("Fund Sucessfully Transfered", customerService.fundTransferOfCustomer(105, 102, 50));
		
	}
	
}
