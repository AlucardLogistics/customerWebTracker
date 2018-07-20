package com.alucard.webCustomerTracker.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends 
AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("*****getRootConfigClasses method");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("*****getServletConfigClasses method");
		return new Class[] {
				WebApplicationContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("*****getServletMappings method");
		return new String[] { "/" };
	}

}
