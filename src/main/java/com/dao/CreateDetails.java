package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ATM;
import com.utility.hibernateUtility;

public class CreateDetails 
{
	public  void create()
	{
		  SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
         
         ATM a = new ATM();
         a.setCardNo(12345678);
         a.setAccHolderName("Nagaraj");
         a.setAccNo(87654321);
         a.setAccPin(1234);
         a.setInitialBal(457289);
         a.setContactNo(701924469);
         a.setAddress("Manvi");
         
         ATM a1 = new ATM();
         a1.setCardNo(43562345);
         a1.setAccHolderName("Sankalpa");
         a1.setAccNo(43215675);
         a1.setAccPin(4567);
         a1.setInitialBal(2500);
         a1.setContactNo(901236789);
         a1.setAddress("Manvi");
   
         ATM a2 = new ATM();
         a2.setCardNo(56748393);
         a2.setAccHolderName("Mahalakshmi");
         a2.setAccNo(25775);
         a2.setAccPin(8756);
         a2.setInitialBal(50000);
         a2.setContactNo(871110890);
         a2.setAddress("Raichur");
         
         ATM a3 = new ATM();
         a3.setCardNo(234567891);
         a3.setAccHolderName("Lashu");
         a3.setAccNo(12345678);
         a3.setAccPin(1123);
         a3.setInitialBal(12000);
         a3.setContactNo(934123412);
         a3.setAddress("Navalkal");        
                                          
         session.save(a);
         
         session.save(a1);

         session.save(a2);

         session.save(a3); 

		 System.out.println("Inserted Successfully");
		 session.getTransaction().commit();
	     session.close();
	  	 sessionFactory.close();

         }
}
