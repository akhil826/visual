package com.ak.Banking.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ak.Banking.factoryclass.FactorySession;
import com.ak.Banking.model.Customer;


/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/CheckBlanceServlet")
public class CheckBlanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	
	HttpSession session=request.getSession();
	
	int account= (int) session.getAttribute("account");
	
	
	
	
	Session session2=FactorySession.configUtil();

	Transaction txn = session2.beginTransaction();
	try {
		
	    Customer customer = session2.get(Customer.class, account); 
		txn.commit();
		request.setAttribute("balance", customer.getBalance());
		request.getRequestDispatcher("checkbalance.jsp").forward(request, response);
		
	}
	
	catch (Exception e) {
		
		response.sendRedirect("FaliureRegister.html");
		
	}
	
	      
	        
	        
	
	}
      
}
