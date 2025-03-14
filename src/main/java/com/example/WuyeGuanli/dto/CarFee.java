package com.example.WuyeGuanli.dto;

import java.time.LocalDateTime;

//跨表
/*
 * dto(entity)這邊的變數是返回欄位
 * .XML是查欄位條件
 * 例如XML需要ˋ查時間 那邊就要列出這個欄位
 * 但dto這邊的變數是返回欄位 不想顯示時間 那就不用列出
 * 
 * */
public class CarFee {
	private String parking;
	private int parkingFee;
	private String owner;
	private boolean paid;
	private String receiveMoneyAccount;
	private int receive;
	private String sendMoneyAccount;
	
	public CarFee() {
		super();
		// TODO 自動產生的建構子 Stub
	}

	public CarFee(String parking, int parkingFee, String owner, boolean paid, String receiveMoneyAccount, int receive,
			 String sendMoneyAccount) {
		super();
		this.parking = parking;
		this.parkingFee = parkingFee;
		this.owner = owner;
		this.paid = paid;
		this.receiveMoneyAccount = receiveMoneyAccount;
		this.receive = receive;
		this.sendMoneyAccount = sendMoneyAccount;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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
	
	
	
	
}
