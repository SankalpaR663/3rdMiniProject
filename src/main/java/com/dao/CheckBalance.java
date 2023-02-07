package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class CheckBalance 
{
	public void balanceEnquiry(long cardNo)
	{
		try
		{
			SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();		  		
		         
			ATM a = (ATM)session.get(ATM.class,cardNo);			
		           	   
			System.out.println("Your initial balance is : "+a.getInitialBal());			       		      		       		  
			  
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
