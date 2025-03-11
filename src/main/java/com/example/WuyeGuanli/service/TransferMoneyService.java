package com.example.WuyeGuanli.service;

import java.time.LocalDateTime;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                newTransferMoney.setBalance(0); // 初始餘額為0，不再隨機
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
    
    /**
     * 獲取用戶當前餘額
     * 
     * @param account 用戶帳號
     * @return 當前餘額
     */
    public int getCurrentBalance(String account) {
        TransferMoney existingTransferMoney = transferMoneyDAO.getTransferMoneyByAccount(account);
        if (existingTransferMoney != null) {
            return existingTransferMoney.getBalance();
        }
        return 0; // 如果帳戶不存在，返回0
    }
    
    /**
     * 根據操作類型和金額更新transfer_money資料
     * 
     * @param transferMoney 包含帳號、操作金額等信息
     * @param operationType 操作類型：1-存款，2-提款，3-轉帳
     * @return 操作結果訊息
     */
    public String updateTransferMoney(TransferMoney transferMoney, int operationType) {
        // 1. 先查詢該帳號的餘額
        TransferMoney existingTransferMoney = transferMoneyDAO.getTransferMoneyByAccount(transferMoney.getAccount());
        
        if (existingTransferMoney != null) {
            int currentBalance = existingTransferMoney.getBalance();
            int amount = transferMoney.getTransfer();
            int newBalance;
            
            // 2. 根據操作類型處理
            switch (operationType) {
                case 1: // 存款 - 增加餘額
                    newBalance = currentBalance + amount;
                    logger.info("存款操作: 帳號 {} 存入 {}, 原餘額 {}, 新餘額 {}", 
                                transferMoney.getAccount(), amount, currentBalance, newBalance);
                    break;
                    
                case 2: // 提款 - 減少餘額
                    if (currentBalance < amount) {
                        return "餘額不足，無法提款";
                    }
                    newBalance = currentBalance - amount;
                    logger.info("提款操作: 帳號 {} 提取 {}, 原餘額 {}, 新餘額 {}", 
                                transferMoney.getAccount(), amount, currentBalance, newBalance);
                    break;
                    
                case 3: // 轉帳 - 減少餘額
                    if (currentBalance < amount) {
                        return "餘額不足，無法進行轉帳";
                    }
                    newBalance = currentBalance - amount;
                    logger.info("轉帳操作: 帳號 {} 轉出 {}, 原餘額 {}, 新餘額 {}", 
                                transferMoney.getAccount(), amount, currentBalance, newBalance);
                    break;
                    
                default:
                    return "不支援的操作類型";
            }
            
            // 3. 更新轉帳金額和餘額
            transferMoney.setBalance(newBalance);
            transferMoney.setUpdateTime(LocalDateTime.now()); // 更新時間
            transferMoneyDAO.updateTransferMoney(transferMoney);
            
            String operationName = (operationType == 1) ? "存款" : (operationType == 2) ? "提款" : "轉帳";
            return operationName + "成功，當前餘額: " + newBalance; // 成功後回傳成功訊息和當前餘額
        } else {
            return "該帳戶不存在"; // 帳戶不存在的錯誤訊息
        }
    }
}