package com.alucard.webCustomerTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alucard.webCustomerTracker.dao.CustomerDAO;
import com.alucard.webCustomerTracker.entity.Customer;
import com.alucard.webCustomerTracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer DAO
//	@Autowired
//	private CustomerDAO customerDAO;
	
	//inject customer Service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from Service
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers", customers);
		
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String customerForm(Model theModel) {
		
		//create mode attribute to bind from data
		Customer theCustomer = new Customer();		
		theModel.addAttribute("customer", theCustomer);		
		return "customerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using the service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customerForm";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		//search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "listCustomers";
	}

}
