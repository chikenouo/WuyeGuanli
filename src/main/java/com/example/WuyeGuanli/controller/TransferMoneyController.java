package com.example.WuyeGuanli.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WuyeGuanli.dto.GetMoney;
import com.example.WuyeGuanli.dto.LoginRequest;
import com.example.WuyeGuanli.dto.LoginResponse;
import com.example.WuyeGuanli.dto.TransferMoney;
import com.example.WuyeGuanli.entity.Role;
import com.example.WuyeGuanli.entity.User;
import com.example.WuyeGuanli.repository.UserRepository;
import com.example.WuyeGuanli.service.AuthService;
import com.example.WuyeGuanli.service.GetMoneyService;
import com.example.WuyeGuanli.service.MoneyTransferService;
import com.example.WuyeGuanli.service.TransferMoneyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class TransferMoneyController {
	private static final Logger logger = LoggerFactory.getLogger(TransferMoneyController.class);

	@Autowired
	private AuthService authService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransferMoneyService transferMoneyService;

	@Autowired
	private GetMoneyService getMoneyService;
	
	@Autowired
	private MoneyTransferService moneyTransferService;

	/**
	 * 用戶登錄API 繞過AuthService中的角色限制 允許所有角色 (admin, landlord, tenant) 登入
	 */
	@PostMapping("/wallet/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
		logger.info("收到登錄請求: {}", loginRequest.getIdentityNumber());

		try {
			// 直接查詢用戶，繞過AuthService的角色限制
			var users = userRepository.findByIdentityNumber(loginRequest.getIdentityNumber());

			// 如果沒有找到用戶，返回錯誤
			if (users.isEmpty()) {
				logger.warn("登錄失敗: 用戶不存在");
				Map<String, Object> errorResponse = new HashMap<>();
				errorResponse.put("success", false);
				errorResponse.put("message", "帳號或密碼錯誤");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}

			// 尋找匹配密碼的用戶
			User matchedUser = null;
			for (User user : users) {
				if (user.getPassword().equals(loginRequest.getPassword())) {
					matchedUser = user;
					break;
				}
			}

			// 如果沒有找到匹配密碼的用戶
			if (matchedUser == null) {
				logger.warn("登錄失敗: 密碼錯誤");
				Map<String, Object> errorResponse = new HashMap<>();
				errorResponse.put("success", false);
				errorResponse.put("message", "帳號或密碼錯誤");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}

			// 確認用戶角色是否為支持的角色 (admin, landlord, tenant)
			if (matchedUser.getRole() == Role.admin || matchedUser.getRole() == Role.landlord
					|| matchedUser.getRole() == Role.tenant) {

				logger.info("用戶: {} 登錄成功，角色: {}", matchedUser.getName(), matchedUser.getRole());

				// 創建自定義的登錄響應
				LoginResponse response = new LoginResponse();
				response.setSuccess(true);
				response.setUserId(matchedUser.getId());
				response.setName(matchedUser.getName());
				response.setRole(matchedUser.getRole());
				response.setToken(generateToken()); // 生成令牌
				response.setMessage("登錄成功");

				// 建立 session
				HttpSession session = request.getSession(true);

				// 存儲關鍵用戶信息到 session
				session.setAttribute("userId", matchedUser.getId());
				session.setAttribute("userName", matchedUser.getName());
				session.setAttribute("userRole", matchedUser.getRole().toString());
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("identityNumber", loginRequest.getIdentityNumber());
				session.setAttribute("token", response.getToken());

				// 如果是首次登錄，確保在 transfer_money 表中創建記錄
				transferMoneyService.handleUserLogin(loginRequest.getIdentityNumber());

				logger.debug("已創建 Session，JSESSIONID: {}", session.getId());

				return ResponseEntity.ok(response);
			} else {
				logger.warn("登錄失敗: 不支持的用戶角色: {}", matchedUser.getRole());
				Map<String, Object> errorResponse = new HashMap<>();
				errorResponse.put("success", false);
				errorResponse.put("message", "不支持的用戶角色");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}
		} catch (Exception e) {
			logger.error("登錄過程中發生錯誤", e);

			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("success", false);
			errorResponse.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	/**
	 * 生成簡單的令牌
	 */
	private String generateToken() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 用戶登出API 清除Session
	 */
	@GetMapping("/wallet/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Map<String, Object> response = new HashMap<>();

		try {
			if (session != null) {
				logger.info("用戶登出: {}", session.getAttribute("userName"));

				// 清除session
				session.invalidate();

				response.put("success", true);
				response.put("message", "成功登出");

				return ResponseEntity.ok(response);
			} else {
				logger.warn("登出請求未找到有效session");

				response.put("success", false);
				response.put("message", "未登入");

				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}
		} catch (Exception e) {
			logger.error("登出過程中發生錯誤", e);

			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 檢查用戶登入狀態API 返回當前Session信息
	 */
	@GetMapping("/wallet/check-session")
	public ResponseEntity<?> checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Map<String, Object> response = new HashMap<>();

		try {
			if (session != null && session.getAttribute("isLoggedIn") != null
					&& (Boolean) session.getAttribute("isLoggedIn")) {

				logger.debug("Session檢查: 用戶已登入: {}", session.getAttribute("userName"));

				// 返回當前登入用戶的信息
				response.put("isLoggedIn", true);
				response.put("userId", session.getAttribute("userId"));
				response.put("userName", session.getAttribute("userName"));
				response.put("userRole", session.getAttribute("userRole"));
				response.put("identityNumber", session.getAttribute("identityNumber"));

				return ResponseEntity.ok(response);
			} else {
				logger.debug("Session檢查: 用戶未登入");

				response.put("isLoggedIn", false);

				return ResponseEntity.ok(response);
			}
		} catch (Exception e) {
			logger.error("檢查Session過程中發生錯誤", e);

			response.put("isLoggedIn", false);
			response.put("error", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 獲取用戶當前餘額API
	 */
	@GetMapping("/wallet/balance")
	public ResponseEntity<?> getBalance(@RequestParam("account") String account) {
		try {
			int currentBalance = transferMoneyService.getCurrentBalance(account);

			Map<String, Object> response = new HashMap<>();
			response.put("success", true);
			response.put("account", account);
			response.put("balance", currentBalance);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("獲取餘額時發生錯誤: ", e);

			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("success", false);
			errorResponse.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	/**
	 * 存款API
	 */
	@PostMapping("/wallet/deposit")
	public ResponseEntity<?> deposit(@RequestBody TransferMoney transferMoney) {
		Map<String, Object> response = new HashMap<>();

		try {
			// 呼叫存款方法 (operationType=1 表示存款)
			String result = transferMoneyService.updateTransferMoney(transferMoney, 1);

			if (result.startsWith("存款成功")) {
				response.put("success", true);
				response.put("message", result);
				return ResponseEntity.ok(response);
			} else {
				response.put("success", false);
				response.put("message", result);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			logger.error("處理存款時發生錯誤: ", e);
			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 提款API
	 */
	@PostMapping("/wallet/withdraw")
	public ResponseEntity<?> withdraw(@RequestBody TransferMoney transferMoney) {
		Map<String, Object> response = new HashMap<>();

		try {
			// 呼叫提款方法 (operationType=2 表示提款)
			String result = transferMoneyService.updateTransferMoney(transferMoney, 2);

			if (result.startsWith("提款成功")) {
				response.put("success", true);
				response.put("message", result);
				return ResponseEntity.ok(response);
			} else {
				response.put("success", false);
				response.put("message", result);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			logger.error("處理提款時發生錯誤: ", e);
			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 轉帳API
	 */
	@PostMapping("/wallet/transfer") //被/money/moneytransfer取代
	public ResponseEntity<?> transfer(@RequestBody TransferMoney transferMoney) {
		Map<String, Object> response = new HashMap<>();

		try {
			// 呼叫轉帳方法 (operationType=3 表示轉帳)
			String result = transferMoneyService.updateTransferMoney(transferMoney, 3);

			if (result.startsWith("轉帳成功")) {
				response.put("success", true);
				response.put("message", result);
				return ResponseEntity.ok(response);
			} else {
				response.put("success", false);
				response.put("message", result);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			logger.error("處理轉帳時發生錯誤: ", e);
			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

	}

	/**
	 * 原來的轉帳API（保留向下兼容）
	 */
	@PostMapping("/wallet/updateTransferMoney")
	public ResponseEntity<Map<String, Object>> updateTransferMoney(@RequestBody TransferMoney transferMoney) {
		Map<String, Object> response = new HashMap<>();

		try {
			// 調用新的轉帳方法 (operationType=3)
			String result = transferMoneyService.updateTransferMoney(transferMoney, 3);

			if (result.startsWith("轉帳成功")) {
				response.put("success", true);
				response.put("message", "轉帳成功");
				return ResponseEntity.ok(response);
			} else {
				response.put("success", false);
				response.put("message", result);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			logger.error("處理轉帳時發生錯誤: ", e);
			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	// 以下匯款API

	/**
	 * 取得合併後的資金記錄列表API(所有) 可用
	 */
	@GetMapping("/money/records")
	public ResponseEntity<?> getMoneyRecords(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Map<String, Object> response = new HashMap<>();

		try {
			// 檢查用戶是否已登入
			if (session == null || session.getAttribute("isLoggedIn") == null
					|| !(Boolean) session.getAttribute("isLoggedIn")) {

				logger.warn("未登入用戶嘗試訪問資金記錄");
				response.put("success", false);
				response.put("message", "請先登入");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}

			// 取得合併後的資金記錄列表
			List<GetMoney> records = getMoneyService.getMoneyMergerList();

			logger.info("成功取得 {} 筆資金記錄", records.size());
			response.put("success", true);
			response.put("records", records);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("獲取資金記錄時發生錯誤", e);

			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 根據帳戶和金額查詢資金記錄API
	 */
	@GetMapping("/money/search")//由對應帳號和金額查詢收款紀錄(目前沒用 條件不嚴謹)
	public ResponseEntity<?> searchMoneyRecords(@RequestParam("account") String account,
			@RequestParam("amount") int amount, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		Map<String, Object> response = new HashMap<>();

		try {
			// 檢查用戶是否已登入
			if (session == null || session.getAttribute("isLoggedIn") == null
					|| !(Boolean) session.getAttribute("isLoggedIn")) {

				logger.warn("未登入用戶嘗試搜索資金記錄");
				response.put("success", false);
				response.put("message", "請先登入");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}

			logger.info("搜索資金記錄 - 帳戶: {}, 金額: {}", account, amount);

			// 查詢符合條件的資金記錄
			List<GetMoney> records = getMoneyService.getMoneyRecordsByAccountAndAmount(account, amount);

			logger.info("搜索到 {} 筆符合條件的資金記錄", records.size());
			response.put("success", true);
			response.put("records", records);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("搜索資金記錄時發生錯誤", e);

			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * 新增收款記錄API
	 */
	@PostMapping("/money/moneytransfer")
	public ResponseEntity<?> addMoneyRecord(@RequestBody GetMoney getMoney, HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    Map<String, Object> response = new HashMap<>();

	    try {
	        // 檢查用戶是否已登入
	        if (session == null || session.getAttribute("isLoggedIn") == null
	                || !(Boolean) session.getAttribute("isLoggedIn")) {
	            logger.warn("未登入用戶嘗試新增收款記錄");
	            response.put("success", false);
	            response.put("message", "請先登入");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }

	        logger.info("處理轉帳請求 - 發送帳戶: {}, 接收帳戶: {}, 金額: {}", 
	                   getMoney.getSendMoneyAccount(), getMoney.getReceiveMoneyAccount(), getMoney.getReceive());
	        
	        // 處理轉帳流程 (提款、存款並記錄)
	        GetMoney newRecord = moneyTransferService.processTransfer(getMoney);

	        logger.info("轉帳已成功完成，記錄ID: {}", newRecord.getId());
	        
	        response.put("success", true);
	        response.put("message", "轉帳已成功完成");
	        response.put("record", newRecord);

	        return ResponseEntity.ok(response);
	    } catch (RuntimeException e) {
	        logger.warn("轉帳處理失敗: {}", e.getMessage());
	        
	        response.put("success", false);
	        response.put("message", e.getMessage());
	        
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    } catch (Exception e) {
	        logger.error("處理轉帳時發生錯誤", e);

	        response.put("success", false);
	        response.put("message", "系統錯誤，請稍後再試");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	/**
	 * 取得特定帳戶的收款記錄API
	 */
	@GetMapping("/money/account")//條件不嚴謹 暫時無用
	public ResponseEntity<?> getAccountRecords(@RequestParam("account") String account, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Map<String, Object> response = new HashMap<>();

		try {
			// 檢查用戶是否已登入
			if (session == null || session.getAttribute("isLoggedIn") == null
					|| !(Boolean) session.getAttribute("isLoggedIn")) {

				logger.warn("未登入用戶嘗試獲取帳戶收款記錄");
				response.put("success", false);
				response.put("message", "請先登入");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}

			// 檢查請求的帳戶是否與登入的用戶匹配
			String loggedInIdentity = (String) session.getAttribute("identityNumber");
			String userRole = (String) session.getAttribute("userRole");

			// 只有管理員或查詢自己的帳戶才允許
			if (!userRole.equals("admin") && !account.equals(loggedInIdentity)) {
				logger.warn("用戶嘗試查詢他人帳戶記錄: {}", account);
				response.put("success", false);
				response.put("message", "無權查詢此帳戶資訊");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
			}

			logger.info("獲取帳戶收款記錄 - 帳戶: {}", account);

			// 獲取該帳戶的所有記錄
			List<GetMoney> records = getMoneyService.getMoneyMergerList().stream()
					.filter(record -> record.getReceiveMoneyAccount().equals(account)).toList();

			logger.info("找到 {} 筆帳戶收款記錄", records.size());
			response.put("success", true);
			response.put("account", account);
			response.put("records", records);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("獲取帳戶收款記錄時發生錯誤", e);

			response.put("success", false);
			response.put("message", "系統錯誤，請稍後再試");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}