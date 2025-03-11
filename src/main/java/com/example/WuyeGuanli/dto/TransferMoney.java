package com.example.WuyeGuanli.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransferMoney {
	// Table: transfer_money
	private String account;
	private int transfer;
	private int balance;
	private LocalDateTime updateTime;

	// Table: users
	private String identityNumber;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getTransfer() {
		return transfer;
	}
	public void setTransfer(int transfer) {
		this.transfer = transfer;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TransferMoney(String account, int transfer, int balance, LocalDateTime updateTime, String identityNumber,
			String password) {
		super();
		this.account = account;
		this.transfer = transfer;
		this.balance = balance;
		this.updateTime = updateTime;
		this.identityNumber = identityNumber;
		this.password = password;
	}
	public TransferMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
