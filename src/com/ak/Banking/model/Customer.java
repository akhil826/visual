package com.ak.Banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BankData")
public class Customer {
    
	
	@Id
	@Column(name="Account_number")
	private int accnumber;
	
	@Column(name="First_Name")
	private String firstname;
	
	@Column(name="Last_Name")
	private String lastname;
	
	@Column(name="Email_id")
	private String emailid;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Branch")
	private String Branch;

	@Column(name="Balance")
	private long balance;
     
	
	



	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(int accnumber) {
		this.accnumber = accnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}




	
}
