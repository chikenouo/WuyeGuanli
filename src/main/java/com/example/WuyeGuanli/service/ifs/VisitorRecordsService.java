package com.example.WuyeGuanli.service.ifs;

import com.example.WuyeGuanli.vo.BasicRes;
import com.example.WuyeGuanli.vo.VisitorAddReq;
import com.example.WuyeGuanli.vo.VisitorRecordgetAllres;
import com.example.WuyeGuanli.vo.VisitorleaveReq;
import com.example.WuyeGuanli.vo.getNamegetAllReq;


public interface VisitorRecordsService 
{
	public BasicRes addinfo(VisitorAddReq req);
	public BasicRes leave  (VisitorleaveReq req);
	public VisitorRecordgetAllres getAll();
	public VisitorRecordgetAllres getNamegetAll(getNamegetAllReq req);
}
