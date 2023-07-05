package com.mml.sb.myrestapi.model;

public class Transaction {
	private String cardNumber;
	private double amount;
	
	
	public Transaction(String cardNumber, double amount) {
		super();
		this.cardNumber = cardNumber;
		this.amount = amount;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
