package com.alucard.webCustomerTracker.service;

import java.util.List;

import com.alucard.webCustomerTracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
