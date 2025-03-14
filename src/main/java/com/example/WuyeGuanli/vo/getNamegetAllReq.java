package com.example.WuyeGuanli.vo;

import java.time.LocalDateTime;

public class getNamegetAllReq {
	
	private String owerName;
	private LocalDateTime starDateTime;
	private LocalDateTime endDateTime;

	public getNamegetAllReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public getNamegetAllReq(String owerName, LocalDateTime starDateTime, LocalDateTime endDateTime) {
		super();
		this.owerName = owerName;
		this.starDateTime = starDateTime;
		this.endDateTime = endDateTime;
	}

	public String getOwerName() {
		return owerName;
	}

	public LocalDateTime getStarDateTime() {
		return starDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

}
