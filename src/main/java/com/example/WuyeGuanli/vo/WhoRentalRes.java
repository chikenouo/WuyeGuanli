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
	
	private int total; //rental表
	
	private String name;  //=user表

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WhoRentalRes(int statusCode, String message,Integer idwhoRental, String rentalWhat, String accountRental, boolean returnYorN,
			boolean verify, LocalDateTime changeTime, int total, String name) {
		super(statusCode, message);
		this.idwhoRental = idwhoRental;
		this.rentalWhat = rentalWhat;
		this.accountRental = accountRental;
		this.returnYorN = returnYorN;
		this.verify = verify;
		this.changeTime = changeTime;
		this.total = total;
		this.name = name;
	}

	public WhoRentalRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WhoRentalRes(int statusCode, String message) {
		super(statusCode, message);
		// TODO Auto-generated constructor stub
	}

	public WhoRentalRes(int i, String string, Integer idwhoRental2, String rentalWhat2, String accountRental2,
			boolean returnYorN2, boolean verify2, LocalDateTime changeTime2) {
		// TODO Auto-generated constructor stub
	}

	

}
