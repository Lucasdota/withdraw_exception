package model.entities;

import model.exceptions.LimitException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void deposit(Double amount) {
		setBalance(balance + amount);
	}
	
	public void withdraw(Double amount) {
		if (amount > withdrawLimit) {
			throw new LimitException("The amount exceeds withdraw limit");
		} else if (amount > balance) {
			throw new LimitException("Not enough balance");
		}
		setBalance(balance - amount);
	}
	
}
