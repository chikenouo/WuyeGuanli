package com.example.WuyeGuanli.dto;

import java.time.LocalDateTime;

public class WhoRentalDTO {
	private int idwhoRental;// who_rental表
	private String rentalWhat; // who_rental表rentalWhat=rental表item
	private int total; // rental表item
	private String accountRental; // who_rental表accountRental=user表account
	private String name; // =user表name
	private boolean returnYorN; // who_rental表
	private boolean verify; // who_rental表
	private LocalDateTime changeTime; // who_rental表
	
	
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getIdwhoRental() {
		return idwhoRental;
	}

	public void setIdwhoRental(int idwhoRental) {
		this.idwhoRental = idwhoRental;
	}

	public LocalDateTime getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(LocalDateTime changeTime) {
		this.changeTime = changeTime;
	}

	public WhoRentalDTO(int idwhoRental, String rentalWhat, int total, String accountRental, String name,
			boolean returnYorN, boolean verify, LocalDateTime changeTime) {
		super();
		this.idwhoRental = idwhoRental;
		this.rentalWhat = rentalWhat;
		this.total = total;
		this.accountRental = accountRental;
		this.name = name;
		this.returnYorN = returnYorN;
		this.verify = verify;
		this.changeTime = changeTime;
	}

	

}
