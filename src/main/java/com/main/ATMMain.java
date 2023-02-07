package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.CheckBalance;
import com.dao.CreateDetails;
import com.dao.DeleteDetails;
import com.dao.DepositAmount;
import com.dao.GetAccCredentials;
import com.dao.PinGeneration;
import com.dao.UpdateDetails;
import com.dao.ViewAccounts;
import com.dao.WithdrawAmount;
import com.entity.ATM;

public class ATMMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		long w_amt = 0;
		long d_amt = 0;
		int flag = 0, createDetailsFlag = 0;
		int pinGenerateFlag = 0, pinFlag = 0;
		String s;
		
		ATM a = new ATM();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("====================================================================");
		System.out.println("================= ATM Interface System =============================");
		System.out.println("====================================================================");
		
		System.out.println("============= Welcome to SBI =============================");
		System.out.println("====================================================================");
		System.out.println("Please insert your card");
		System.out.println("Please do not remove your chip card. Leave your card inserted during the entire transaction");
		
		System.out.println("********* ATM MANAGEMENT SYSTEM **********");
		
			System.out.println("Enter the card number: ");
			long cardNo = sc.nextLong();
			
			a.setCardNo(cardNo);
			
			flag = new GetAccCredentials().accCredentials(cardNo);
			
			do 
			{	
				if(pinGenerateFlag == 1)
				{
					flag = new GetAccCredentials().accCredentials(cardNo);
					pinFlag = 0;
					pinGenerateFlag = 0;
				}
			
				if(pinFlag == 0 && flag == 1)
				{										
					System.out.println("Valid pin\nUser Authentication successfull!!");	
					pinFlag = 1;
				}
				else if(flag == 0)
				{
					System.out.println("Invalid pin\n User Authentication failed!!");
					break;
				}				
										
				if(createDetailsFlag == 0)
				{
					System.out.println("*************************************************");
					System.out.println("1. Create accounts");
					System.out.println("2. Display all accounts");
					System.out.println("3. Update existing account");
					System.out.println("4. Delete account");
					System.out.println("5. Cash Deposit");
					System.out.println("6. Cash Withdraw");
					System.out.println("7. Balance Enquiry");
					System.out.println("8. Pin Generation");
					System.out.println("*************************************************");
				}
				else
				{
					System.out.println("*************************************************");
					System.out.println("2. Insert new account");
					System.out.println("3. Update existing account");
					System.out.println("4. Delete account");
					System.out.println("5. Cash Deposit");
					System.out.println("6. Cash Withdraw");
					System.out.println("7. Balance Enquiry");
					System.out.println("8. Pin Generation");
					System.out.println("*************************************************");
				}
				
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			if(choice == 1 && createDetailsFlag == 1)
			{
				System.out.println("Accounts are already created!!");
				break;
			}
			else
			{
				//
			}
		    					
			
			switch(choice)
			{
				case 1 : 
                         new CreateDetails().create();
                         createDetailsFlag = 1;
						 break;
						 
				case 2 : 
				 		 new ViewAccounts().view();						 
						 break;
						 						 	 
				case 3 : 
						 new UpdateDetails().update();
						 break;
			
				case 4 : 
					 	 new DeleteDetails().delete();
						 break;
						 
				case 5 : 
						 System.out.println("Enter the Deposit amount: ");
						 d_amt = sc.nextLong();			 	 									 	 
						 new DepositAmount().cashDeposit(d_amt, cardNo);						
						 break;
						 
				case 6 :
						 System.out.println("Enter the Withdraw amount: ");
						 w_amt = sc.nextLong();
						 new WithdrawAmount().cashWithdraw(w_amt, cardNo);
						 break;
						 
				case 7: 
						 new CheckBalance().balanceEnquiry(cardNo);
						 break;
						 
				case 8: 
						 new PinGeneration().pinGenerate(cardNo);
						 pinGenerateFlag = 1;
						 break;
						 
				default :
					  	 System.out.println("Invalid choice");
						 break;
			}
			System.out.println("Do you want to continue? (Y-Yes / N-No)");
			s=sc.next();
		}
			while(s.equals("Y")||s.equals("y"));
			System.out.println("====================================================================");
			System.out.println("Please remove your card \nThanks for visiting!!");
			System.out.println("Bye....");	

	}

}
