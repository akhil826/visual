package com.ak.Banking.servlet;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.ak.Banking.factoryclass.FactorySession;
import com.ak.Banking.factoryclass.QueryData;
import com.ak.Banking.model.Customer;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		
		try {
			String ammounts = request.getParameter("ammount");
			long ammount = Long.parseLong(ammounts);
			
			String accounts = request.getParameter("acccount");
			int benificaryAccount = Integer.parseInt(accounts);
			
			Session session = FactorySession.configUtil();
			
			Customer customer = session.get(Customer.class, benificaryAccount);
			
			HttpSession session1 = request.getSession();
			
			long userbalance = (long) session1.getAttribute("balance");
			 int Useraccount = (int) session1.getAttribute("account");
			 
		
			 
			long currentBalance = userbalance - ammount;
			
			int number = 0;
			if(currentBalance>-1) {
			if (customer != null) {
				number = QueryData.balanceQuery(currentBalance, userbalance);
			}
			else {
				
				response.sendRedirect("errorquery.html");
			}
			}
			else {
				
				response.sendRedirect("insfuctiet.html");
			}
			if (number == 1) {
                
				long benfiBalance = customer.getBalance();
				long updateBalance = benfiBalance + ammount;
				String customerName = customer.getFirstname();
				
				request.setAttribute("username", customerName);
				int customerValue = QueryData.balanceQuery(updateBalance, benfiBalance);

				if (customerValue == 1) {
					
					long transctionId=ThreadLocalRandom.current().nextLong(1000000000000L);
					QueryData.transcationQuery(ammount,benificaryAccount,Useraccount,transctionId);
					request.getRequestDispatcher("transcaional.jsp").forward(request, response);
					
				} else {
					response.sendRedirect("transcationfaliure.html");
				}
			} 
			
		} catch (Exception e) {

		  e.printStackTrace();
		}
	          
	           
	}

}
