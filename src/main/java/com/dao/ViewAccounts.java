package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class ViewAccounts 
{
	public void view()
	{
		try
		{
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  
		@SuppressWarnings("unchecked")
		Query<ATM> query1=session.createQuery("from ATM");
	         
	     List<ATM> result=query1.list();
	         
	         
	       for(ATM a:result)
	       {
	    	   System.out.println(a.getCardNo());
		       System.out.println(a.getAccHolderName()); 
		       System.out.println(a.getAccNo());
		       System.out.println(a.getAccPin());
		       System.out.println(a.getInitialBal());
		       System.out.println(a.getContactNo());
		       System.out.println(a.getAddress());
		      
	       }

		  
		  
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
