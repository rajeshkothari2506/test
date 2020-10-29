package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customer_information")
public class Customer {
	
	public Customer(String customerName, String customerAddress, List<Account> accountInfromation) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.accountInfromation = accountInfromation;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "cust_name",nullable = false)
	private String customerName;
	
	@Column(name = "cust_address",nullable = false)
	private String customerAddress;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Account> accountInfromation;
	
	public Customer() {}
	
	
	
	public List<Account> getAccountInfromation() {
		return accountInfromation;
	}
	public void setAccountInfromation(List<Account> accountInfromation) {
		this.accountInfromation = accountInfromation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
