package com.example.WuyeGuanli.vo;

import java.util.List;

import com.example.WuyeGuanli.entity.VisitorRecords;

public class VisitorRecordgetAllres extends BasicRes 
{
 	private List<VisitorRecords> visitorRecords ;

	public VisitorRecordgetAllres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitorRecordgetAllres(int statusCode, String message ,List<VisitorRecords> visitorRecords) {
		super(statusCode, message);
		this.visitorRecords = visitorRecords;
		// TODO Auto-generated constructor stub
	}

	public VisitorRecordgetAllres(List<VisitorRecords> visitorRecords) {
		super();
		this.visitorRecords = visitorRecords;
	}

	public List<VisitorRecords> getVisitorRecords() {
		return visitorRecords;
	}

	public void setVisitorRecords(List<VisitorRecords> visitorRecords) {
		this.visitorRecords = visitorRecords;
	}
 	
	

}
