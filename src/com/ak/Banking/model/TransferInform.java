package com.ak.Banking.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transation_Details")
public class TransferInform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transcation_Count")
	private int id;
	
	@Column(name = "Beneficiary_Account_ID")
	private int Beneficiaryaccountid;
	
	@Column(name = "Transfer_Ammount")
	private long ammount;

	@Column(name = "User_Account_ID")
	private int useraccountid;
	
	@Column(name = "Transcation_ID")
	
	
	private long transcationID;
	
	@Column(name = "TranscationDate")
	private String dateformate;
	
	


	public TransferInform() {
		Date date=new Date();
		SimpleDateFormat ft = 
		 new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a");
		dateformate=ft.format(date);
	}

	public long getAmmount() {
		return ammount;
	}

	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}

	public int getBeneficiaryaccountid() {
		return Beneficiaryaccountid;
	}

	public void setBeneficiaryaccountid(int beneficiaryaccountid) {
		Beneficiaryaccountid = beneficiaryaccountid;
	}

	public int getUseraccountid() {
		return useraccountid;
	}

	public void setUseraccountid(int useraccountid) {
		this.useraccountid = useraccountid;
	}

	public long getTranscationID() {
		return transcationID;
	}

	public void setTranscationID(long transcationID) {
		this.transcationID = transcationID;
	}

	public String getDateformate() {
		return dateformate;
	}

	public void setDateformate(String dateformate) {
		this.dateformate = dateformate;
	}

   
    
	
	

}
