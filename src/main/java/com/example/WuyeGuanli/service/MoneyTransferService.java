package com.example.WuyeGuanli.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WuyeGuanli.dto.GetMoney;
import com.example.WuyeGuanli.dto.TransferMoney;

@Service
public class MoneyTransferService {
	private static final Logger logger = LoggerFactory.getLogger(MoneyTransferService.class);

	@Autowired
	private TransferMoneyService transferMoneyService;

	@Autowired
	private GetMoneyService getMoneyService;

	/**
	 * 執行完整的轉帳流程：從發送者扣款，給接收者存款，並記錄交易
	 * 
	 * @param getMoney GetMoney對象，包含發送者、接收者和金額信息
	 * @return 新增的交易記錄
	 */
	@Transactional
	public GetMoney processTransfer(GetMoney getMoney) {
		String senderAccount = getMoney.getSendMoneyAccount();
		String receiverAccount = getMoney.getReceiveMoneyAccount();
		int amount = getMoney.getReceive();

		logger.info("處理轉帳 - 發送帳戶: {}, 接收帳戶: {}, 金額: {}", senderAccount, receiverAccount, amount);

		// 步驟 1: 執行提款操作 (從發送者帳戶扣款)
		TransferMoney withdrawRequest = new TransferMoney();
		withdrawRequest.setAccount(senderAccount);
		withdrawRequest.setTransfer(amount);

		String withdrawResult = transferMoneyService.updateTransferMoney(withdrawRequest, 2); // 2表示提款

		// 檢查提款操作是否成功
		if (!withdrawResult.startsWith("提款成功")) {
			logger.warn("轉帳失敗: 提款操作失敗 - {}", withdrawResult);
			throw new RuntimeException("轉帳失敗: " + withdrawResult);
		}

		// 步驟 2: 執行存款操作 (增加接收者帳戶餘額)
		TransferMoney depositRequest = new TransferMoney();
		depositRequest.setAccount(receiverAccount);
		depositRequest.setTransfer(amount);

		String depositResult = transferMoneyService.updateTransferMoney(depositRequest, 1); // 1表示存款

		// 檢查存款操作是否成功
		if (!depositResult.startsWith("存款成功")) {
			logger.error("轉帳過程中出錯: 提款成功但存款失敗 - {}", depositResult);
			// 由於有@Transactional注解，拋出異常會導致整個事務回滾，包括之前的提款操作
			throw new RuntimeException("轉帳過程中發生錯誤: " + depositResult);
		}

		// 步驟 3: O了2: 確保有時間戳
		if (getMoney.getTimeOfReceivingMoney() == null) {
			getMoney.setTimeOfReceivingMoney(LocalDateTime.now());
		}

		// 步驟 4: 建立轉帳記錄
		GetMoney newRecord = getMoneyService.addMoneyRecord(getMoney);

		logger.info("轉帳完成 - 記錄ID: {}", newRecord.getId());

		return newRecord;
	}
}
