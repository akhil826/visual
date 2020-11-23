package com.ak.Banking.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import org.hibernate.query.Query;

import com.ak.Banking.factoryclass.FactorySession;
import com.ak.Banking.model.Customer;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	Session session=FactorySession.configUtil();
	 try {
		String sqlQuery = "from Customer  where firstname=:firstname and password=:password";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(sqlQuery);
		query.setParameter("firstname", username);
		query.setParameter("password", password);
		Customer customer = (Customer) query.uniqueResult();
		
			request.setAttribute("accid", customer.getAccnumber());
			request.setAttribute("firstName", customer.getFirstname());
			request.setAttribute("email", customer.getEmailid());
			request.setAttribute("balance", customer.getBalance());
			request.getRequestDispatcher("information.jsp").forward(request, response);
		
			 HttpSession session2=request.getSession();
			    session2.setAttribute("balance",  customer.getBalance());
		        session2.setAttribute("account", customer.getAccnumber());
		
	} catch (Exception e) {

	     response.sendRedirect("FaliureRegister.html");
	}
	 
	   
	}

}
