package com.example.WuyeGuanli.vo;

import jakarta.validation.constraints.NotNull;

public class addinfoReq extends BasicRes {
	@NotNull(message = "門牌不能為空")
	private String partitionhousenumber;
	@NotNull(message = "住戶名字不能為空")
	private String owerName;
	@NotNull(message = "住戶手機不能為空")
	private String owerPhone;
	@NotNull(message = "")
	private boolean lease;

	private String residentname;

	private String residentphonenumber;

	public addinfoReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public addinfoReq(int statusCode, String message) {
		super(statusCode, message);
		// TODO Auto-generated constructor stub
	}

	public addinfoReq(@NotNull String partitionhousenumber, @NotNull String owerName, @NotNull String owerPhone,
			@NotNull boolean lease, String residentname, String residentphonenumber) {
		super();
		this.partitionhousenumber = partitionhousenumber;
		this.owerName = owerName;
		this.owerPhone = owerPhone;
		this.lease = lease;
		this.residentname = residentname;
		this.residentphonenumber = residentphonenumber;
	}

	public String getPartitionhousenumber() {
		return partitionhousenumber;
	}

	public String getOwerName() {
		return owerName;
	}

	public String getOwerPhone() {
		return owerPhone;
	}

	public boolean isLease() {
		return lease;
	}

	public String getResidentname() {
		return residentname;
	}

	public String getResidentphonenumber() {
		return residentphonenumber;
	}
}
