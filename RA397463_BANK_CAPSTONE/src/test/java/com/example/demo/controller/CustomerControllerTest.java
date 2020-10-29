package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CustomerServiceImpl  customerService;
	
	@Test
	public void getgetAllCustomerOfBanks() throws Exception {
		
	RequestBuilder request = MockMvcRequestBuilders.get("/all").accept(org.springframework.http.MediaType.APPLICATION_JSON);	
	Customer c1 = new Customer("c1","Gandhi Nagar",null);
	Customer c2 = new Customer("c2","Surat",null);
	
	List<Customer> listOfCustomer =  new ArrayList<>();
	
	listOfCustomer.add(c1);
	listOfCustomer.add(c2);
	
	MvcResult mvcresult = mockMvc.perform(request).andReturn();
	when(customerService.getAllCustomer()).thenReturn(listOfCustomer);
	//assertEquals(true, mvcresult.getResponse().getContentAsString().contains("Gandhi Nagar"));
	
	
	}
	
	

	
}
