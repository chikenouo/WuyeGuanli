package com.example.WuyeGuanli.dto;

public class WhoRentalDTO {
	private String rentalWhat; //rental表
	private String accountRental; //user表
	private String name;  //user表
	private String address; //user表
	private boolean returnYorN; //who_rental表
	private boolean verify; //who_rental表
	public String getRentalWhat() {
		return rentalWhat;
	}
	public void setRentalWhat(String rentalWhat) {
		this.rentalWhat = rentalWhat;
	}
	public String getAccountRental() {
		return accountRental;
	}
	public void setAccountRental(String accountRental) {
		this.accountRental = accountRental;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isReturnYorN() {
		return returnYorN;
	}
	public void setReturnYorN(boolean returnYorN) {
		this.returnYorN = returnYorN;
	}
	
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	public WhoRentalDTO() {
		super();
		// TODO 自動產生的建構子 Stub
	}
	public WhoRentalDTO(String rentalWhat, String accountRental, String name, String address, boolean returnYorN,
			boolean verify) {
		super();
		this.rentalWhat = rentalWhat;
		this.accountRental = accountRental;
		this.name = name;
		this.address = address;
		this.returnYorN = returnYorN;
		this.verify = verify;
	}
	
	
}
