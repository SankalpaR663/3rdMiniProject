package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class WithdrawAmount 
{
	public void cashWithdraw(long w_amt, long cardNo)
	{
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  
		ATM a = (ATM)session.get(ATM.class,cardNo);
		 
		a.setInitialBal(a.getInitialBal()-w_amt);					  		 	 
		 		  
		 System.out.println("Withdraw of amount Successfully");
		 session.getTransaction().commit();
		 sessionFactory.close();

	}
}
