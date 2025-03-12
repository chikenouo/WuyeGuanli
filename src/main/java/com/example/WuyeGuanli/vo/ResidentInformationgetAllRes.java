package com.example.WuyeGuanli.vo;

import java.util.List;

import com.example.WuyeGuanli.entity.Resident_Information;

public class ResidentInformationgetAllRes extends BasicRes {
	private List<Resident_Information> resident_Informations;

	public ResidentInformationgetAllRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResidentInformationgetAllRes(int statusCode, String message ,List<Resident_Information> res) {
		super(statusCode, message );
		this.resident_Informations = res;
		// TODO Auto-generated constructor stub
	}

	public ResidentInformationgetAllRes(List<Resident_Information> resident_Informations) {
		super();
		this.resident_Informations = resident_Informations;
	}

	public List<Resident_Information> getResident_Informations() {
		return resident_Informations;
	}

}
