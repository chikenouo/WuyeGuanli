package com.example.WuyeGuanli.dto;

import java.time.LocalDateTime;
//匯款API

public class GetMoney {

	// Table: transfer_money
//	private String account;// =receiveMoneyAccount
//	private int transfer; // 是XXX(其他account)匯款金額=private int receive 收款金額
//	private int balance; // 是receiveMoneyAccount 的餘額

	// Table: get_money
	private Integer id; // (PK 自動增加)
	private String receiveMoneyAccount;
	private int receive;
	private String remark;
	private LocalDateTime timeOfReceivingMoney;
	private String sendMoneyAccount;
	private String addressRemark; //  這是 SQL 查詢產生的，不是資料庫欄位
	private String feeforRemark;

	public GetMoney() {
		super();
		// TODO 自動產生的建構子 Stub
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

	public String getSendMoneyAccount() {
		return sendMoneyAccount;
	}

	public void setSendMoneyAccount(String sendMoneyAccount) {
		this.sendMoneyAccount = sendMoneyAccount;
	}

	public String getAddressRemark() {
		return addressRemark;
	}

	public void setAddressRemark(String addressRemark) {
		this.addressRemark = addressRemark;
	}

	public String getFeeforRemark() {
		return feeforRemark;
	}

	public void setFeeforRemark(String feeforRemark) {
		this.feeforRemark = feeforRemark;
	}

	public GetMoney(Integer id, String receiveMoneyAccount, int receive, String remark,
			LocalDateTime timeOfReceivingMoney, String sendMoneyAccount, String addressRemark, String feeforRemark) {
		super();
		this.id = id;
		this.receiveMoneyAccount = receiveMoneyAccount;
		this.receive = receive;
		this.remark = remark;
		this.timeOfReceivingMoney = timeOfReceivingMoney;
		this.sendMoneyAccount = sendMoneyAccount;
		this.addressRemark = addressRemark;
		this.feeforRemark = feeforRemark;
	}

	


}
