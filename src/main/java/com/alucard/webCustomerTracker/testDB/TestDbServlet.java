package com.alucard.webCustomerTracker.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class TestDbServlet
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("******TestDbServlet doGet method");
		
		//setup connection variables
		String user = "alucard";
		String pass = "alucard";
		
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection to the data base
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcURL);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			
			out.println("Success!... pheew");
			
			myConn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e); // see exception in browser
		}
	}

}
