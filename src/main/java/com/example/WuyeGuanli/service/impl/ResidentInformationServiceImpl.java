package com.example.WuyeGuanli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.WuyeGuanli.vo.BasicRes;
import com.example.WuyeGuanli.vo.DashBoardSearchRes;
import com.example.WuyeGuanli.vo.DeleteinformationReq;
import com.example.WuyeGuanli.vo.ResidentInformationgetAllRes;
import com.example.WuyeGuanli.vo.UpdateReq;
import com.example.WuyeGuanli.vo.addinfoReq;
import com.example.WuyeGuanli.dao.ResidentInformationDaoNMSL;
import com.example.WuyeGuanli.entity.Resident_Information;
import com.example.WuyeGuanli.service.ifs.ResidentInformationService;

import jakarta.transaction.Transactional;

@Service
public class ResidentInformationServiceImpl implements ResidentInformationService {

	@Autowired
	ResidentInformationDaoNMSL residentDao;

	@Transactional(rollbackOn = Exception.class)
	@Override
	public BasicRes addinfo(addinfoReq req) {
		String patternString = "\\d{8}";
		// 檢查房東名字
		if (!StringUtils.hasText(req.getOwerName())) {
			return new BasicRes(400, "住戶名字不能為空!");
		}
		// 檢查房東手機
		if (!StringUtils.hasText(req.getOwerPhone())) {
			return new BasicRes(400, "房東手機號碼不能為空!");
		}
		if (!req.getOwerPhone().matches(patternString)) {
			System.out.println(req.getOwerPhone());
			System.out.println(req.getOwerPhone().matches(patternString));
			System.out.println("手機號碼有誤");
			return new BasicRes(400, "住戶手機號碼格式錯誤");
		}
		patternString = "[A-C]\\d{2}";
		// 判斷門牌號碼
		if (!req.getPartitionhousenumber().matches(patternString)) {
			return new BasicRes(400, "門牌格式錯誤");
		}
		// 判斷是否出租
		if (req.isLease()) {
			// 檢查租戶名字
			if (!StringUtils.hasText(req.getResidentname())) 
			{
				System.out.println("租戶名字");
				return new BasicRes(400, "租戶名字錯");
			}
			patternString = "\\d{8}";
			// 檢查租戶手機
			if (!StringUtils.hasText(req.getResidentphonenumber())|| req.getPartitionhousenumber().matches(patternString)) 
			{
				System.out.println("租戶手機");
				return new BasicRes(400, "租戶手機錯誤");
			}
			if (req.getOwerPhone() == req.getResidentphonenumber()) 
			{
				return new BasicRes(400, "租戶手機已註冊過");
			}
		}
		residentDao.Add(req.getPartitionhousenumber(), req.getOwerName(), req.getOwerPhone(), req.isLease(),
				req.getResidentname(), req.getResidentphonenumber());
		return new BasicRes(200, "成功注入資料");
	}

	@Override
	public ResidentInformationgetAllRes selectAll() {

		 List<Resident_Information> res = residentDao.selectAll();
		 System.out.println(res);
		 return new ResidentInformationgetAllRes(200, "success", res);
	}

	@Override
	public ResidentInformationgetAllRes searchName(String owerName) {
		if(owerName == "1")
		{
			owerName = "";	
		}
		List<Resident_Information> res = residentDao.gatOwnerNameByAll(owerName);
		 return new ResidentInformationgetAllRes(200, "success", res);
	}

	@Override
	public BasicRes deleteinformation(DeleteinformationReq req) {
		System.out.println(req.getPartitionhousenumber());
		residentDao.deleteinformation(req.getPartitionhousenumber());

		return null;
	}

	@Override
	public BasicRes updateinformation(UpdateReq req) 
	{
		String patternString = "\\d{8}";
		Resident_Information res = residentDao.gatPartitionhousenumberByAll(req.getPartitionhousenumber());
		if(!StringUtils.hasText(res.getPartitionhousenumber()))
		{
			return null;
		}
		if (req.getOwerPhone() == null) {
			return new BasicRes(400, "房東手機號碼不能為空!");
		}
		if (!req.getOwerPhone().matches(patternString)) {
			System.out.println(req.getOwerPhone());
			System.out.println(req.getOwerPhone().matches(patternString));
			System.out.println("手機號碼有誤");
			return null;
		}
		patternString = "[A-C]\\d{2}";
		// 判斷門牌號碼
		if (!req.getPartitionhousenumber().matches(patternString)) {
			return null;
		}
		// 判斷是否出租
		if (req.isLease()) {
			// 檢查租戶名字
			if (!StringUtils.hasText(req.getResidentname())) {
				return null;
			}
			// 檢查租戶手機
			patternString = "\\d{8}";
			if (!StringUtils.hasText(req.getResidentphonenumber())
					|| req.getPartitionhousenumber().matches(patternString)) {
				return null;
			}
		}
		residentDao.updateByPartitionhousenumber(req.getPartitionhousenumber(),req.getOwerName(),req.getOwerPhone(),req.isLease(),req.getResidentname(),req.getResidentphonenumber());
		return null;
	}
}
