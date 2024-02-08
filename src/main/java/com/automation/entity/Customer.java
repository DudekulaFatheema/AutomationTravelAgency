package com.automation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int cId;
	private String cName;
	private long cPhoneNo;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int cId, String cName, long cPhoneNo) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhoneNo = cPhoneNo;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcPhoneNo() {
		return cPhoneNo;
	}
	public void setcPhoneNo(long cPhoneNo) {
		this.cPhoneNo = cPhoneNo;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cPhoneNo=" + cPhoneNo + "]";
	}
	
	 }
