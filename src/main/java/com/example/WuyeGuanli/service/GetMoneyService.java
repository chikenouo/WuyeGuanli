package com.example.WuyeGuanli.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WuyeGuanli.dao.GetMoneyDAO;
import com.example.WuyeGuanli.dto.GetMoney;

import jakarta.transaction.Transactional;

@Service
public class GetMoneyService {
    private static final Logger logger = LoggerFactory.getLogger(GetMoneyService.class);
    
    @Autowired
    private GetMoneyDAO getMoneyDAO;

    /**
     * 查詢合併後的資金轉賬記錄
     * 
     * @return 合併的資金記錄列表
     */
    public List<GetMoney> getMoneyMergerList() {
        logger.debug("獲取合併資金記錄列表");
        return getMoneyDAO.moneyMerger();
    }

    /**
     * 新增收款記錄
     * 
     * @param getMoney 收款資訊
     * @return 新增後的記錄 (包含自增ID)
     */
    @Transactional
    public GetMoney addMoneyRecord(GetMoney getMoney) {
        logger.info("新增收款記錄: 收款帳戶 {}, 金額 {}", 
                  getMoney.getReceiveMoneyAccount(), getMoney.getReceive());
        
        // 驗證必填欄位
        if (getMoney.getReceiveMoneyAccount() == null || getMoney.getReceiveMoneyAccount().isEmpty()) {
            logger.warn("收款記錄欄位缺失: 收款帳戶為空");
            throw new IllegalArgumentException("收款帳戶不能為空");
        }
        
        // 設置收款時間為當前時間 (如果未提供)
        if (getMoney.getTimeOfReceivingMoney() == null) {
            getMoney.setTimeOfReceivingMoney(LocalDateTime.now());
        }
        
        // 如果備註為null，設置為空字串
        if (getMoney.getRemark() == null) {
            getMoney.setRemark("");
        }

        // 執行插入操作
        getMoneyDAO.insertGetMoney(getMoney);
        logger.info("成功新增收款記錄，ID: {}", getMoney.getId());

        // 因為使用了自增ID和useGeneratedKeys="true"，此時getMoney對象已經有ID值
        return getMoney;
    }

    /**
     * 根據收款帳戶和金額查詢對應的合併記錄
     * 
     * @param account 收款帳戶
     * @param amount  金額
     * @return 合併的資金記錄列表
     */
    public List<GetMoney> getMoneyRecordsByAccountAndAmount(String account, int amount) {
        logger.debug("搜索資金記錄: 帳戶 {}, 金額 {}", account, amount);
        
        // 優先使用DAO中的直接查詢方法（如果已實現）
        try {
            return getMoneyDAO.findByAccountAndAmount(account, amount);
        } catch (Exception e) {
            logger.warn("直接查詢方法異常，使用過濾方法作為備選: {}", e.getMessage());
            
            // 從全部記錄中過濾出符合條件的記錄（備選方案）
            List<GetMoney> allRecords = getMoneyDAO.moneyMerger();
            return allRecords.stream()
                .filter(record -> record.getReceiveMoneyAccount().equals(account) && record.getReceive() == amount)
                .toList();
        }
    }
    
    /**
     * 根據收款帳戶查詢所有收款記錄
     * 
     * @param account 收款帳戶
     * @return 該帳戶的所有收款記錄
     */
    public List<GetMoney> getMoneyRecordsByAccount(String account) {
        logger.debug("獲取帳戶收款記錄: {}", account);
        
        // 優先使用DAO中的直接查詢方法（如果已實現）
        try {
            return getMoneyDAO.getMoneyByAccount(account);
        } catch (Exception e) {
            logger.warn("直接查詢方法異常，使用過濾方法作為備選: {}", e.getMessage());
            
            // 從全部記錄中過濾出該帳戶的記錄（備選方案）
            List<GetMoney> allRecords = getMoneyDAO.moneyMerger();
            return allRecords.stream()
                .filter(record -> record.getReceiveMoneyAccount().equals(account))
                .toList();
        }
    }
}