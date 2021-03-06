package com.ak.Banking.factoryclass;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ak.Banking.model.TransferInform;


public class QueryData {
  static Session session=null;
  
	public static int balanceQuery(long currentbalance,long userbalance) {
		 
		session=FactorySession.configUtil();
		int id=0;
		try {
			Transaction transaction = session.beginTransaction();
			String sqlquery = "update Customer set balance=:balance where balance=:userbalance";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(sqlquery);
			query.setParameter("balance", currentbalance);
			query.setParameter("userbalance", userbalance);
			id = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {

		e.printStackTrace();
		}
		
		return id;
	}
	
	public static void transcationQuery(long ammount,int Benificaryaccountid,int useraccountid,long transcationid ) {
		
		try {
			Transaction transaction = session.beginTransaction();
			TransferInform transferInform = new TransferInform();
			transferInform.setBeneficiaryaccountid(Benificaryaccountid);
			transferInform.setUseraccountid(useraccountid);
			transferInform.setAmmount(ammount);
			transferInform.setTranscationID(transcationid);
			
			 // transferInform.setDateformate( ft.format(date));
			  
			session.save(transferInform);
			transaction.commit();
		} catch (Exception e) {

		e.printStackTrace();
		}
	}
}
