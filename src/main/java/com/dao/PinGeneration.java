package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class PinGeneration 
{
	public void pinGenerate(long cardNo)
	{
		int previousPin = 0;
		int newPin = 0;
		Scanner sc = new Scanner (System.in);
		
		try
		{
			SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
				
			Session session = sessionFactory.openSession();
			session.beginTransaction();		  		
		         
			ATM a = (ATM)session.get(ATM.class,cardNo);	
			
		    System.out.println("Enter your previous password: ");
		    previousPin = sc.nextInt();
		    
		    if(a.getAccPin() == previousPin)
		    {
		    	System.out.println("Enter your New Pin (4-Digits only)");
		    	newPin = sc.nextInt();
		    	
		    	a.setAccPin(newPin);
		    	System.out.println("Pin generated successfuly");		    	
		    }
		    else
		    {
		    	System.out.println("Invalid pin");
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
