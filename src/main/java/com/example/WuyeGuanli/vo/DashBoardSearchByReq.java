package com.example.WuyeGuanli.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DashBoardSearchByReq {
    private String header;
    private LocalDate startDate;
    private LocalDate endDate;
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
}
