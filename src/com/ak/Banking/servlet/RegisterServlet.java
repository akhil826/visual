package com.ak.Banking.servlet;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ak.Banking.factoryclass.FactorySession;
import com.ak.Banking.model.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String branch = request.getParameter("branch");
	
	 int accnumber=ThreadLocalRandom.current().nextInt(1000000000);
	long Balance = ThreadLocalRandom.current().nextLong(10000l);
	 Session session=FactorySession.configUtil();
	
	
	Customer customer=new Customer();
	
	customer.setAccnumber(accnumber);;
	customer.setFirstname(firstname);
	customer.setLastname(lastname);
	customer.setEmailid(email);
	customer.setPassword(password);
    customer.setBranch(branch);
    customer.setBalance(Balance);
    
    
   
     
     Transaction transaction=session.beginTransaction();
      int pkid=(int) session.save(customer);
     
     transaction.commit();
     
     if (pkid==customer.getAccnumber()) {
		
    	 response.sendRedirect("RegistrationSuccess.html");
	}
     else {
		response.sendRedirect("FaliureRegister.html");
	}
	}
	
	
	

}
