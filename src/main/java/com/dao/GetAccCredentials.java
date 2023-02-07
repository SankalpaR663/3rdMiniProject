package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class GetAccCredentials 
{
	public int accCredentials(long cardNo)
	{
		int flag=0;
		int userEnteredPin=0;
		
		Scanner sc= new Scanner(System.in);
		
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  
		 ATM a = (ATM)session.get(ATM.class,cardNo);
		 		 
		 System.out.println("Enter the Account pin: ");
		 userEnteredPin = sc.nextInt();		
		 		  
		 System.out.println("Account details fetched successfully!! ");
		 session.getTransaction().commit();
		 sessionFactory.close();
		 
		 if(a.getAccPin() == userEnteredPin) 
			 return flag = 1;	
		 else 
			return flag = 0;
	}
}
