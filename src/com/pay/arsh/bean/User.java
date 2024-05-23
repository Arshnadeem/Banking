package com.pay.arsh.bean;

import java.io.Serializable;

public class User implements Serializable
	{

	private static final long serialVersionUID = 1L;
	private String userName,email,ifscCode,bankName,mobile,acccountNumber,history,type;
	private int accountPin;
	private double accountBalance;
	public User()
	{
		
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", mobile=" + mobile + ", acccountNumber=" + acccountNumber + ", history=" + history + ", type=" + type
				+ ", accountPin=" + accountPin + ", accountBalance=" + accountBalance + "]";
	}

	public User(String userName, String email, String ifscCode, String bankName, String mobile, String acccountNumber,
			String history, String type, int accountPin, double accountBalance) {
		super();
		this.userName = userName;
		this.email = email;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.mobile = mobile;
		this.acccountNumber = acccountNumber;
		this.history = history;
		this.type = type;
		this.accountPin = accountPin;
		this.accountBalance = accountBalance;
	}
	



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAcccountNumber() {
		return acccountNumber;
	}
	public void setAcccountNumber(String acccountNumber) {
		this.acccountNumber = acccountNumber;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAccountPin() {
		return accountPin;
	}
	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	 
	}
