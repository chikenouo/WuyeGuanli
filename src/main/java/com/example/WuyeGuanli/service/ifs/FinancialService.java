package com.example.WuyeGuanli.service.ifs;

import com.example.WuyeGuanli.vo.FinancialAddInfoReq;
import com.example.WuyeGuanli.vo.FinancialDelectReq;
import com.example.WuyeGuanli.vo.FinancialSearchReq;
import com.example.WuyeGuanli.vo.FinancialSearchRes;

public interface FinancialService {
	
	public int addInfo(FinancialAddInfoReq req);
	
	public FinancialSearchRes search(FinancialSearchReq req);
	
	public int delect(FinancialDelectReq req);
}
