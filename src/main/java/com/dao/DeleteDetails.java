package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class DeleteDetails 
{
	public void delete() 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter the ATM Card number");
			long cardNo =sc.nextLong();
			
			SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		
			ATM a = (ATM)session.load(ATM.class, cardNo);
			
			session.delete(a);
		
			System.out.println("Deleted Successfully");
			
			session.getTransaction().commit();
			sessionFactory.close();
		}
			
		catch(Exception e)
		{
			System.out.println(e);
		}
			

	}
}
