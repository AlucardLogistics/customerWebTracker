package com.alucard.webCustomerTracker.dao;

import java.util.List;

import com.alucard.webCustomerTracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
