package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class DepositAmount 
{

	public void cashDeposit(long d_amt, long cardNo) 
	{
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  
		ATM a = (ATM)session.get(ATM.class,cardNo);
		 
		a.setInitialBal(a.getInitialBal() + d_amt);					  		 	 
		 		  
		 System.out.println("Amount deposited Successfully");
		 session.getTransaction().commit();
		 sessionFactory.close();

	}
	
}
