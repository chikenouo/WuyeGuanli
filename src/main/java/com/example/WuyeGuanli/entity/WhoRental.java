package com.example.WuyeGuanli.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "who_rental")
public class WhoRental {
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Id
	@Column(name = "idwho_rental")
	private Integer idwhoRental;
	@Column(name = "rental_what")
	private String rentalWhat; //=rental表item
	@Column(name = "account_rental")
	private String accountRental; //=user表account
	@Column(name = "returnyorn")
	private boolean returnYorN; //預設0(否)
	@Column(name = "verify")
	private boolean verify; //預設0(否)
	@Column(name = "change_time")
	private LocalDateTime changeTime; //預設now()
	
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
	public WhoRental(Integer idwhoRental, String rentalWhat, String accountRental, boolean returnYorN, boolean verify,
			LocalDateTime changeTime) {
		super();
		this.idwhoRental = idwhoRental;
		this.rentalWhat = rentalWhat;
		this.accountRental = accountRental;
		this.returnYorN = returnYorN;
		this.verify = verify;
		this.changeTime = changeTime;
	}
	public WhoRental() {
		super();
		// TODO 自動產生的建構子 Stub
	}
/*
	CREATE TABLE `who_rental` (
			  `idwho_rental` int NOT NULL AUTO_INCREMENT,
			  `rental_what` varchar(255) DEFAULT NULL,
			  `account_rental` varchar(255) DEFAULT NULL,
			  `returnyorn` tinyint(1) DEFAULT 0,
			  `verify` tinyint(1) DEFAULT 0,
			  `change_time` datetime DEFAULT CURRENT_TIMESTAMP,
			  PRIMARY KEY (`idwho_rental`)
			) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='哪個帳號租借了啥';
*/
	//連表查
	//受權自動更新
}
