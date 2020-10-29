package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_information")
public class Account {
	public Account(int accountID, String accountType, int availableBalance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountID;

	
	//private int customerId;
	@Column
	private String accountType;
	
	@Column
	private int availableBalance;
	
	
	//@ManyToOne
	//@JoinColumn(name = "id")
	//private Customer customer;
	//private String miniStatement;
	
	
	
/*	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public Account() {
		
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

}
