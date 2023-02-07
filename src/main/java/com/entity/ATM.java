package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ATM")
public class ATM 
{
	@Id
	@Column
	private long cardNo;
	
	@Column
	private String accHolderName;
	
	@Column
	private long accNo;
	
	@Column
	@Size(min = 4, max = 6)
	private int accPin;
	
	@Column
	@Min(value = 2000)
	private long initialBal;
	
	@Column
	private long contactNo;
	
	@Column
	private String address;	
	
	public ATM() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ATM(long cardNo, String accHolderName, long accNo, int accPin, long initialBal, long contactNo,
			String address) 
	{
		super();
		this.cardNo = cardNo;
		this.accHolderName = accHolderName;
		this.accNo = accNo;
		this.accPin = accPin;
		this.initialBal = initialBal;
		this.contactNo = contactNo;
		this.address = address;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public int getAccPin() {
		return accPin;
	}

	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}

	public long getInitialBal() {
		return initialBal;
	}

	public void setInitialBal(long initialBal) {
		this.initialBal = initialBal;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "ATM [cardNo=" + cardNo + ", accHolderName=" + accHolderName + ", accNo=" + accNo + ", accPin=" + accPin
				+ ", initialBal=" + initialBal + ", contactNo=" + contactNo + ", address=" + address + "]";
	}	
		
	
	
/*
	@Override
	public String toString() {
		return "ATM [slNo=" + slNo + ", cardNo=" + cardNo + ", accHolderName=" + accHolderName + ", accNo=" + accNo
				+ ", accPin=" + accPin + ", initialBal=" + initialBal + ", contactNo=" + contactNo + ", address="
				+ address + "]";
	}
	*/
}
