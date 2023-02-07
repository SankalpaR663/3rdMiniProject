package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class UpdateDetails 
{
	public void update()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the card number");
		long cardNo=sc.nextInt();
		
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  
		 ATM a = (ATM)session.get(ATM.class,cardNo);
		  
		  System.out.println("Enter the Account Holder name: ");
		  String accHolderName = sc.next();
		  sc.nextLine();
		  System.out.println("Enter the Account Pin: ");
		  int accPin = sc.nextInt();		  
		  System.out.println("Enter the Contact number: ");
		  long contactNo = sc.nextLong();
		  System.out.println("Enter the Address: ");
		  String address = sc.next();
		  
		 a.setAccHolderName(accHolderName);
		 a.setAccPin(accPin);
		 a.setContactNo(contactNo);
		 a.setAddress(address);		 
		 		  
		 System.out.println("Updated Successfully");
		 session.getTransaction().commit();
		 sessionFactory.close();

	}

}
