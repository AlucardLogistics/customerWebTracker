package com.alucard.webCustomerTracker.config;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.alucard.webCustomerTracker")
@EnableTransactionManagement
public class WebApplicationContextConfig implements WebMvcConfigurer {
	
	//@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("*****configureDefaultServletHandling method");
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		System.out.println("*****InternalResourceViewResolver method");
		
		return resolver;
	}
	
	public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "" ).setViewName( "index" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        //super.addViewControllers( registry );
        System.out.println("*****addViewControllers method");
    }
	
	@Bean
    public MessageSource messageSource() { 
       ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
       resource.setBasename("messages");
       resource.setUseCodeAsDefaultMessage(true);
       System.out.println("*****MessageSource method");
       return resource;    
    }
	
 	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource());
	    sessionFactory.setPackagesToScan("com.alucard.webCustomerTracker.entity");
	        sessionFactory.setHibernateProperties(hibernateProperties());
	 
	        return sessionFactory;
	    }
	 
	    @Bean
	    public DataSource dataSource() {
	    	DataSource dataSource = new DataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/web_customer_tracker");
	        dataSource.setUsername("alucard");
	        dataSource.setPassword("alucard");
	 
	        return dataSource;
	    }
	    
	    @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {
	        HibernateTransactionManager transactionManager
	          = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	 
	    private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty(
	          "hibernate.hbm2ddl.auto", "create-drop");
	        hibernateProperties.setProperty(
	          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	 
	        return hibernateProperties;
	    }
	    
//	    hibernateProperties.setProperty(
//		          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	


}
