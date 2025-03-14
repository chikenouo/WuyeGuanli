package com.example.WuyeGuanli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WuyeGuanli.service.ifs.FinancialService;
import com.example.WuyeGuanli.vo.FinancialAddInfoReq;
import com.example.WuyeGuanli.vo.FinancialDelectReq;
import com.example.WuyeGuanli.vo.FinancialSearchReq;
import com.example.WuyeGuanli.vo.FinancialSearchRes;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FinancialController {
	
	@Autowired FinancialService financialService;
	
	@PostMapping("/Financial/addInfo")
	public int addInfo(@RequestBody FinancialAddInfoReq req) {
		financialService.addInfo(req);
		return 200;}
		
		@PostMapping("/Financial/search")
		public FinancialSearchRes search(@RequestBody FinancialSearchReq req) {
			return financialService.search(req);
	}
		
		@PostMapping("/Financial/delect")
		public int delect(@RequestBody FinancialDelectReq req) {
			return financialService.delect(req);
	}
		}
