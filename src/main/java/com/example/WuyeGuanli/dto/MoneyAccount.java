package com.example.WuyeGuanli.dto;

import java.time.LocalDateTime;

public class MoneyAccount {//已經用不到 跟getmoney一樣

	private String receiveMoneyAccount; //收款帳戶
    private int receive;
    private String sendMoneyAccount; //送款帳戶
    private String remark;     
    private LocalDateTime timeOfReceivingMoney;
	public MoneyAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MoneyAccount(String receiveMoneyAccount, int receive, String sendMoneyAccount, String remark,
			LocalDateTime timeOfReceivingMoney) {
		super();
		this.receiveMoneyAccount = receiveMoneyAccount;
		this.receive = receive;
		this.sendMoneyAccount = sendMoneyAccount;
		this.remark = remark;
		this.timeOfReceivingMoney = timeOfReceivingMoney;
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
	public String getSendMoneyAccount() {
		return sendMoneyAccount;
	}
	public void setSendMoneyAccount(String sendMoneyAccount) {
		this.sendMoneyAccount = sendMoneyAccount;
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
   
    

    
    
}
