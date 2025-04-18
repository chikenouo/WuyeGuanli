package com.example.WuyeGuanli.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.WuyeGuanli.vo.BasicRes;
import com.example.WuyeGuanli.vo.ResidentInformationgetAllRes;
import com.example.WuyeGuanli.vo.VisitorAddReq;
import com.example.WuyeGuanli.vo.VisitorRecordgetAllres;
import com.example.WuyeGuanli.vo.VisitorleaveReq;
import com.example.WuyeGuanli.vo.getNamegetAllReq;
import com.example.WuyeGuanli.dao.ResidentInformationDaoNMSL;
import com.example.WuyeGuanli.dao.VisitorRecordsDao;
import com.example.WuyeGuanli.entity.Resident_Information;
import com.example.WuyeGuanli.entity.VisitorRecords;
import com.example.WuyeGuanli.service.ifs.VisitorRecordsService;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;

@Service
public class VisitorRecordsServiceImpl implements VisitorRecordsService {
	@Autowired
	VisitorRecordsDao visDao;
	
	@Autowired
	ResidentInformationDaoNMSL residentDao;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public BasicRes addinfo(VisitorAddReq req) {
		
		if (!StringUtils.hasText(req.getVisitorName())) 
		{
			return new BasicRes(400, "名字不能為空");
		}
		String patternString = "\\d{10}";
		// 檢查訪客手機
		if (!req.getVisitorPhone().matches(patternString)) {
			System.out.println(req.getVisitorPhone());
			System.out.println(req.getVisitorPhone().matches(patternString));
			System.out.println("手機號碼有誤");
			return new BasicRes(400, "手機號碼有誤");
		}
		//檢查對象是否存在
		String VisitorStr = req.getVisitors().substring(0,3);
		Resident_Information resident_Information = residentDao.gatPartitionhousenumberByAll(VisitorStr);
		if (resident_Information == null) {
			System.out.println("查無此人");
			return new BasicRes(400, "查無此人");
		}
		if (!StringUtils.hasText(resident_Information.getPartitionhousenumber()))
		{
			System.out.println("查無此門牌");
			return new BasicRes(400, "查無此門牌");
		}
		VisitorStr = req.getVisitors().substring(4);
//		if (!resident_Information.isLease()) 
//		{
//			
//			if (resident_Information.getOwerName().equals(req.getVisitorName()))
//			{
//				
//				System.out.println("查無此人");
//				return null;
//			}
//		}
//		else 
//		{
//			if (!resident_Information.getOwerName().equals(req.getVisitorName()))
//			{
//				System.out.println("查無此人");
//				return null;
//			}
//		}
		if ( !StringUtils.hasText(req.getVisitorReason()))
		{
			return new BasicRes(400, "原因不能為空");
		}
		System.out.println("成功");
		visDao.Add(req.getVisitorName(),req.getVisitorPhone() ,req.getVisitorReason() , req.getVisitors());
		 return new BasicRes(200, "成功");
	}

	@Override
	public BasicRes leave(VisitorleaveReq req) 
	{
		int res = visDao.gitId(req.getId());
		
		if (res != req.getId()) 
		{
			System.out.println("查無此資料");
			return null;
		}
		System.out.println("離開成功");
		visDao.getIdByleave(req.getId(),req.isLeave());
		return null;
	}


	@Override
	public VisitorRecordgetAllres getNamegetAll(getNamegetAllReq req) {
		// TODO Auto-generated method stub
		LocalDateTime startTime = req.getStarDateTime();
		LocalDateTime endTime = req.getEndDateTime();
		if (startTime == null ||startTime.toString() == "") 
		{
			startTime = LocalDateTime.of(1970, 1, 1, 0, 0);
		}
		if (endTime == null||endTime.toString() == "") 
		{
			endTime = LocalDateTime.of(2999, 1, 1, 0, 0);
		}
		List<VisitorRecords> resList = visDao.gatNameByAll(req.getOwerName(), startTime, endTime);
		return new VisitorRecordgetAllres (200, "success", resList);
	}

	@Override
	public VisitorRecordgetAllres getAll() {
		
		List<VisitorRecords> resList = visDao.gitAll();
		System.out.println(resList);
		// TODO Auto-generated method stub
		 return new VisitorRecordgetAllres(200, "success", resList);
	}
}
