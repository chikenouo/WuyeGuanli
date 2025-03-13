package com.example.WuyeGuanli.dto;

//子查詢+跨表+子查詢+
public class CarFee {
	private String parking;
	private int parkingFee;
	private String owner;
	private boolean paid;
	public CarFee() {
		super();
		// TODO 自動產生的建構子 Stub
	}
	public CarFee(String parking, int parkingFee, String owner, boolean paid) {
		super();
		this.parking = parking;
		this.parkingFee = parkingFee;
		this.owner = owner;
		this.paid = paid;
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
	
	
	
}
