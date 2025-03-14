package com.example.WuyeGuanli.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.WuyeGuanli.dao.FinancialDao;
import com.example.WuyeGuanli.entity.Financial;
import com.example.WuyeGuanli.service.ifs.FinancialService;
import com.example.WuyeGuanli.vo.FinancialAddInfoReq;
import com.example.WuyeGuanli.vo.FinancialAddInfoVo;
import com.example.WuyeGuanli.vo.FinancialDelectReq;
import com.example.WuyeGuanli.vo.FinancialSearchReq;
import com.example.WuyeGuanli.vo.FinancialSearchRes;

@Service
public class FinancialServiceImpl implements FinancialService{

	@Autowired FinancialDao financialDao;
	
	@Override
	public int addInfo(FinancialAddInfoReq req) {
		
		if (!StringUtils.hasText(req.getProject())) {
//			return new BasicRes(400,"項目名稱是必填");
			return 400;
		}
		
		if (req.getIncome() < 0) {
//			return new BasicRes(400,"收入金額不能為負的");
			return 400;
		}
		
		if (req.getExpenditure() < 0) {
//			return new BasicRes(400,"支出金額不能為負的");
			return 400;
		}
		
		if (req.getDate() == null) {
//			return new BasicRes(400,"請檢查日期是否正確");
			return 400;
		}
		
		financialDao.addInfoDao(req.getProject(),req.getIncome(),req.getExpenditure(),req.getDate(), req.getRemark(),req.getReceipt());
		
//		return new BasicRes(200,"成功");
		return 200;
	}

	@Override
	public FinancialSearchRes search(FinancialSearchReq req) {
		
		String name = req.getName();
		if (!StringUtils.hasText(name)) {		
			name="";
		}
		LocalDate sDate =req.getsDate();
		if(sDate == null) {
			sDate =LocalDate.of(1911, 1, 1);
		}
		LocalDate eDate =req.geteDate();
		if (eDate == null) {
			eDate = LocalDate.of(2999, 12, 31);
		}
		
		List<Financial> res = financialDao.search(name, sDate, eDate);
		return new FinancialSearchRes(200,"成功",res);
	}

	@Override
	public int delect(FinancialDelectReq req) {
		financialDao.delectInfo(req.getIds());
		return 0;
	}

	

	
	
}
