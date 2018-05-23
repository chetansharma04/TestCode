package com.chetan.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.customer.bo.CustomerBo;
import com.chetan.customer.bo.impl.CustomerBoImpl;

public class App {
	public static void main(String[] args) throws Exception {
	      @SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Cutomer.xml");
	      CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
	      customer.addCustomer();
	      System.out.println("\\\\\\");
	      customer.addCustomerAround("chetan");
	      System.out.println("\\\\\\");
	      customer.addCustomerReturnValue();
	      System.out.println("\\\\\\");
	      customer.addCustomerThrowException();
	      System.out.println("\\\\\\");
	      
	}
	
}
