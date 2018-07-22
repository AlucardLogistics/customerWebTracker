package com.alucard.webCustomerTracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alucard.webCustomerTracker.dao.CustomerDAO;
import com.alucard.webCustomerTracker.entity.Customer;
import com.alucard.webCustomerTracker.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//inject customerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers() {
		
		System.out.println("*******CustomerServiceImpl getCustomers method");
		return customerDAO.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		System.out.println("*******CustomerServiceImpl saveCustomer method");
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

}
