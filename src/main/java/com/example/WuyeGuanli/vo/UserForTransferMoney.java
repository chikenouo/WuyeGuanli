package com.example.WuyeGuanli.vo;

public class UserForTransferMoney extends BasicRes {
	private String identityNumber;
	private String password;

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

	public UserForTransferMoney(String identityNumber, String password) {
		super();
		this.identityNumber = identityNumber;
		this.password = password;
	}

	public UserForTransferMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserForTransferMoney(int statusCode, String message) {
		super(statusCode, message);
		// TODO Auto-generated constructor stub
	}

}
