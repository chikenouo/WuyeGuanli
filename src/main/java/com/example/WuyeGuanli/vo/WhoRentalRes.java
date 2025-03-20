package com.example.WuyeGuanli.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.WuyeGuanli.entity.WhoRental;

import jakarta.persistence.Column;

public class WhoRentalRes extends BasicRes{

	private Integer idwhoRental;

	private String rentalWhat; //=rental表item

	private String accountRental; //=user表account

	private boolean returnYorN; //預設0(否)
	
	private boolean verify; //預設0(否)
	
	private LocalDateTime changeTime; //預設now()

	public WhoRentalRes() {
		super();
		// TODO 自動產生的建構子 Stub
	}

	public WhoRentalRes(int statusCode, String message) {
		super(statusCode, message);
		// TODO 自動產生的建構子 Stub
	}

	public WhoRentalRes(int statusCode, String message,Integer idwhoRental, String rentalWhat, String accountRental, boolean returnYorN,
			boolean verify, LocalDateTime changeTime) {
		super(statusCode, message);
		this.idwhoRental = idwhoRental;
		this.rentalWhat = rentalWhat;
		this.accountRental = accountRental;
		this.returnYorN = returnYorN;
		this.verify = verify;
		this.changeTime = changeTime;
	}

	

	public Integer getIdwhoRental() {
		return idwhoRental;
	}

	public void setIdwhoRental(Integer idwhoRental) {
		this.idwhoRental = idwhoRental;
	}

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

	public LocalDateTime getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(LocalDateTime changeTime) {
		this.changeTime = changeTime;
	}

}
