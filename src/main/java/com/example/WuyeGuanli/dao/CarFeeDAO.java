package com.example.WuyeGuanli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WuyeGuanli.dto.CarFee;

@Mapper
public interface CarFeeDAO {
	
	//輸入匯款帳號查匯款給102420484096帳號的所以繳車位費資訊
	public List<CarFee> carFeeMarger(@Param("account")String send_money_account);
	
	//查全部
	public List<CarFee> getAllCarFee();
}
