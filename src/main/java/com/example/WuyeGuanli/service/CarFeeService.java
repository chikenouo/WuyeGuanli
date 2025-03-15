package com.example.WuyeGuanli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WuyeGuanli.dao.CarFeeDAO;
import com.example.WuyeGuanli.dto.CarFee;

@Service
public class CarFeeService {
	@Autowired
	private CarFeeDAO carFeeDAO;

	//匯款帳號查匯款給102420484096帳號的'一年內總共'繳車位費資訊
	@Transactional
	public List<CarFee> carFeeMarger() {
		return carFeeDAO.carFeeMarger();
	}

	 //根據匯款金額自動更新車位費用支付狀態
    @Transactional
    public int updateCarFeePaidStatus() {
        return carFeeDAO.updateCarFeePaidStatus();
    }
    
    public void saveOrUpdateCarFee(CarFee carFee) {
        carFeeDAO.insertOrUpdateCarFee(carFee);
    }
}
