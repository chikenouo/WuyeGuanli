package com.example.WuyeGuanli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WuyeGuanli.dto.GetMoney;

@Mapper
public interface GetMoneyDAO {// SQL語法
	
	public List<GetMoney> moneyMerger(); // 合表

	public void insertGetMoney(GetMoney getMoney);

	/**
	 * 根據ID獲取收款記錄
	 * 
	 * @param id 記錄ID
	 * @return 收款記錄
	 */
	public GetMoney getMoneyById(@Param("id") Long id);

	/**
	 * 根據收款帳號獲取所有收款記錄
	 * 
	 * @param account 收款帳號
	 * @return 收款記錄列表
	 */
	public List<GetMoney> getMoneyByAccount(@Param("account") String account);

	/**
	 * 根據收款帳號和金額獲取收款記錄
	 * 
	 * @param account 收款帳號
	 * @param amount  收款金額
	 * @return 收款記錄列表
	 */
	public List<GetMoney> findByAccountAndAmount(@Param("account") String account, @Param("amount") int amount);
}
