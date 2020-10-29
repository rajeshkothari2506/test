package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountService accountService;

	public CustomerServiceImpl() {

	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if (customer == null) {
			throw new CustomerNotFoundException("Customer Doesn't exists with valid parameter ");
		}

		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerByID(int id) throws CustomerNotFoundException {

		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer Doesn't exists for customer  ID " + id);
		}
		return customer.get();
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomerInformation(Customer customer) throws CustomerNotFoundException {

		findCustomerByID(customer.getId());// to check if customer exist of not for id
		return customerRepository.save(customer);

	}

	@Override
	public void deleteCustomerByID(int id) throws CustomerNotFoundException {
		// Customer customer = null;
		findCustomerByID(id);
		customerRepository.deleteById(id);
	}

	@Override
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}

	@Override
	public String fundTransferOfCustomer(int fromAccount, int toAccount, int amount)
			throws CustomerNotFoundException, AccountNotFoundException {

		String fundResult = null;
		Account from = accountService.findAccountByID(fromAccount);
		Account to = accountService.findAccountByID(toAccount);

		if (fromAccount == toAccount) {
			throw new AccountNotFoundException("You Can Not Transfer Ammount in same account ");
		} else {
			if (from.getAvailableBalance() > amount) {
				to.setAvailableBalance(to.getAvailableBalance() + amount);
				from.setAvailableBalance(from.getAvailableBalance() - amount);
				accountService.saveAccount(from);
				accountService.saveAccount(to);
				fundResult = "Fund Sucessfully Transfered";
			} else {
				fundResult = "Account " + fromAccount + " Does not have sufficent balance to transfer...";
			}
		}
		return fundResult;
	}

	@Override
	public List<Customer> findCustomerByName(String customerName) {

		List<Customer> listOfAllCustomer = customerRepository.findByCustomerName(customerName);
		if (listOfAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found with Name : " + customerName);
		}
		return listOfAllCustomer;

	}

	@Override
	public List<Customer> findCustomerByAddress(String customerAddress) {
		List<Customer> listOfAllCustomer = customerRepository.findByCustomerAddress(customerAddress);
		if (listOfAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found with customer Address : " + customerAddress);
		}
		return listOfAllCustomer;

	}

}
