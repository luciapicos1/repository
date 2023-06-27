package com.mywork.app.mywork;

public class BankAccount {
	private float balance;
	
	public BankAccount(float balance) {
		this.balance=balance;
	}

	public float getBalance() {
		return balance;
	}

	public void makeMoney(float money) {
		//the bookshop gets money
		balance+=money;
		
	}
	
	
}
