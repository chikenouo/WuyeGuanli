package com.example.WuyeGuanli.dto;

import java.time.LocalDateTime;
//匯款API

public class GetMoney {

	// Table: transfer_money
	private String account;// =receiveMoneyAccount
	private int transfer; // 是XXX(其他account)匯款金額=private int receive 收款金額
	private int balance; // 是receiveMoneyAccount 的餘額

	// Table: get_money
	private Integer id; // (PK 自動增加)
	private String receiveMoneyAccount;
	private int receive;
	private String remark;
	private LocalDateTime timeOfReceivingMoney;
	private String sendMoneyAccount;

	public GetMoney() {
		super();
		// TODO 自動產生的建構子 Stub
	}



	public String getSendMoneyAccount() {
		return sendMoneyAccount;
	}



	public void setSendMoneyAccount(String sendMoneyAccount) {
		this.sendMoneyAccount = sendMoneyAccount;
	}



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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReceiveMoneyAccount() {
		return receiveMoneyAccount;
	}

	public void setReceiveMoneyAccount(String receiveMoneyAccount) {
		this.receiveMoneyAccount = receiveMoneyAccount;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getTimeOfReceivingMoney() {
		return timeOfReceivingMoney;
	}

	public void setTimeOfReceivingMoney(LocalDateTime timeOfReceivingMoney) {
		this.timeOfReceivingMoney = timeOfReceivingMoney;
	}



	public GetMoney(String account, int transfer, int balance, Integer id, String receiveMoneyAccount, int receive,
			String remark, LocalDateTime timeOfReceivingMoney, String sendMoneyAccount) {
		super();
		this.account = account;
		this.transfer = transfer;
		this.balance = balance;
		this.id = id;
		this.receiveMoneyAccount = receiveMoneyAccount;
		this.receive = receive;
		this.remark = remark;
		this.timeOfReceivingMoney = timeOfReceivingMoney;
		this.sendMoneyAccount = sendMoneyAccount;
	}

}
