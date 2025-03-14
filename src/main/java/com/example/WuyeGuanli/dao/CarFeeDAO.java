package com.example.WuyeGuanli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WuyeGuanli.dto.CarFee;

@Mapper
public interface CarFeeDAO {
	
	//匯款帳號查匯款給102420484096帳號的'一年內總共'繳車位費資訊
	public List<CarFee> carFeeMarger();
	
	//獨立功能：根據匯款金額自動更新車位費用支付狀態
    public int updateCarFeePaidStatus();
    
    public void insertOrUpdateCarFee(CarFee carFee);
}
