package com.mml.sb.myrestapi.model;

public class Account {
	private String accountNum;
	private String cardNumber;
	private String name;
	
	
	public Account(String accountNum, String cardNumber, String name) {
		super();
		this.accountNum = accountNum;
		this.cardNumber = cardNumber;
		this.name = name;
	}


	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
