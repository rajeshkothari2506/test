package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
@Component
public interface CustomerService {
	Customer saveCustomer(Customer customer);
	Customer findCustomerByID(int id);
	public List<Customer> getAllCustomer();
	public Customer updateCustomerInformation(Customer customer);
	public void deleteCustomerByID(int id);
	public void deleteAllCustomer();
	public String fundTransferOfCustomer(int fromAccount,int toAccount,int amount) throws CustomerNotFoundException,AccountNotFoundException;
	List<Customer> findCustomerByName(String customerName);	
	public List<Customer> findCustomerByAddress(String customerAddress);
}
