package com.ak.Banking.factoryclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ak.Banking.model.Customer;
import com.ak.Banking.model.TransferInform;



public class FactorySession {

	
	static Session session;
	static SessionFactory sessionFactory;
	
	static {
		
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(TransferInform.class).buildSessionFactory();
	 
	}
	
	public static Session configUtil() {
		
		

		
		try {
			if (sessionFactory != null) {
				session = sessionFactory.openSession();
				
			}
		}
		 catch (Exception e) {
			if (session==null) {
				session.close();
			}
		}
		return session;
	}
	
	
}
