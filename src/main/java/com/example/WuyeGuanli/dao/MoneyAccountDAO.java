package com.example.WuyeGuanli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WuyeGuanli.dto.GetMoney;
import com.example.WuyeGuanli.dto.MoneyAccount;

@Mapper
public interface MoneyAccountDAO {

	
	/**
	 * 根據收款帳號獲取所有收款記錄
	 * 
	 * @param account 收款帳號
	 * @return 收款記錄列表
	 */
	public List<MoneyAccount> getMoneyByReceiveAccount(@Param("receive_money_account") String receiveMoneyAccount);

	public List<MoneyAccount> getMoneyBySendReceiveAccount(@Param("account") String account);

}
