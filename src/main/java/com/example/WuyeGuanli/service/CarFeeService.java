package com.example.WuyeGuanli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WuyeGuanli.dao.CarFeeDAO;
import com.example.WuyeGuanli.dto.CarFee;

@Service
public class CarFeeService {
	@Autowired
	private CarFeeDAO carFeeDAO;

	// 輸入匯款帳號查匯款給102420484096帳號的所以繳車位費資訊
	public List<CarFee> carFeeMarger(String send_money_account) {
		return carFeeDAO.carFeeMarger(send_money_account);
	}

	public List<CarFee> getAllCarFee() {
		return carFeeDAO.getAllCarFee();
	}

}
