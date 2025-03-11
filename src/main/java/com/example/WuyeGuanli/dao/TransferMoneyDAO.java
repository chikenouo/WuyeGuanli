package com.example.WuyeGuanli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.WuyeGuanli.dto.TransferMoney;
@Mapper
public interface TransferMoneyDAO {

	List<TransferMoney> getTransferMoneyUserDTO(); // 合表

	// 插入新的 transfer_money 資料
	void insertTransferMoney(TransferMoney transferMoney);

	// 根據帳號檢查是否已存在資料
	TransferMoney getTransferMoneyByAccount(String account);
}
