package com.example.WuyeGuanli.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.WuyeGuanli.dao.TransferMoneyDAO;
import com.example.WuyeGuanli.dto.TransferMoney;

@Service
public class TransferMoneyService {
    private static final Logger logger = LoggerFactory.getLogger(TransferMoneyService.class);
    
    @Autowired
    private TransferMoneyDAO transferMoneyDAO;
    
    /**
     * 處理用戶登入時的錢包創建邏輯
     * 如果錢包不存在，則在transfer_money表中創建新記錄
     * 
     * @param identityNumber 用戶身份證號
     */
    public void handleUserLogin(String identityNumber) {
        if (identityNumber == null || identityNumber.isEmpty()) {
            logger.warn("處理用戶登入時收到無效的身份證號");
            return;
        }
        
        try {
            logger.debug("檢查用戶錢包是否存在: {}", identityNumber);
            
            // 檢查transfer_money表中是否已有此帳戶
            // 注意：這裡我們直接使用identityNumber作為account
            String account = identityNumber;
            
            TransferMoney existingTransferMoney = transferMoneyDAO.getTransferMoneyByAccount(account);
            
            if (existingTransferMoney == null) {
                logger.info("創建新錢包帳戶: {}", account);
                
                // 如果transfer_money表中沒有該帳號，則新增一條資料
                TransferMoney newTransferMoney = new TransferMoney();
                newTransferMoney.setAccount(account);
                newTransferMoney.setTransfer(0);
                newTransferMoney.setBalance(0);
                newTransferMoney.setUpdateTime(LocalDateTime.now()); // 設定當前時間
                
                // 插入資料到transfer_money表
                transferMoneyDAO.insertTransferMoney(newTransferMoney);
                
                logger.info("已成功創建錢包帳戶: {}", account);
            } else {
                logger.debug("錢包帳戶已存在: {}", account);
            }
        } catch (Exception e) {
            logger.error("處理用戶登入錢包時發生錯誤: {}", identityNumber, e);
            // 這裡我們只記錄錯誤但不拋出，以避免影響用戶登入流程
        }
    }
}