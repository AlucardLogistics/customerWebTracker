package com.alucard.webCustomerTracker.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alucard.webCustomerTracker.dao.CustomerDAO;
import com.alucard.webCustomerTracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query and sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		
		System.out.println("*******CustomerDAOImpl getCustomers method");
		//return results
		return customers;
	}


	public void saveCustomer(Customer theCustomer) {
		
		System.out.println("*******CustomerDAOImpl saveCustomer method");
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the customer to the data base
		currentSession.saveOrUpdate(theCustomer);
	}


	public Customer getCustomer(int theId) {
		
		System.out.println("*******CustomerDAOImpl getCustomer method");
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query and get customer based on the id/primary key requested
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	public void deleteCustomer(int theId) {
		
		System.out.println("*******CustomerDAOImpl deleteCustomer method");
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId"); // "customerId" match with setParameter method
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}


}
