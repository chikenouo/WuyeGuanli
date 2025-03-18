package com.example.WuyeGuanli.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.WuyeGuanli.entity.Financial;
import com.example.WuyeGuanli.vo.FinancialAddInfoReq;


import jakarta.transaction.Transactional;

@Repository
public interface FinancialDao extends JpaRepository<Financial, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into financial (project,income,expenditure,date,remark,receipt) values (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
	public int addInfoDao(String project, int income, int expenditure, LocalDate date, String remark,String receipt);
	
	@Query(value = "select * from financial where project like %?1% and date >= ?2 and date <= ?3", nativeQuery = true)
	public List<Financial> search(String name, LocalDate sDate, LocalDate eDate);
	
	@Modifying
	@Transactional
	@Query(value = "delete from financial where id in (?1)", nativeQuery = true)
	public int delectInfo(List<Integer> ids);
}
