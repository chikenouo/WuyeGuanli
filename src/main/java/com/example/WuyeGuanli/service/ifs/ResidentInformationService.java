package com.example.WuyeGuanli.service.ifs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.WuyeGuanli.vo.BasicRes;
import com.example.WuyeGuanli.vo.DeleteinformationReq;
import com.example.WuyeGuanli.vo.ResidentInformationgetAllRes;
import com.example.WuyeGuanli.vo.UpdateReq;
import com.example.WuyeGuanli.vo.addinfoReq;
import com.example.WuyeGuanli.entity.Resident_Information;

public interface ResidentInformationService 
{
	public BasicRes addinfo(addinfoReq req);
	public ResidentInformationgetAllRes selectAll();
	public ResidentInformationgetAllRes searchName(String owerName);
	public BasicRes deleteinformation(DeleteinformationReq req);
	public BasicRes updateinformation(UpdateReq req);
	
}
