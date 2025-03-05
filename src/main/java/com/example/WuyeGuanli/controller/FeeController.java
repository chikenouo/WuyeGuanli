package com.example.WuyeGuanli.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WuyeGuanli.entity.FeeInfo;
import com.example.WuyeGuanli.service.ifs.FeeInfoService;
import com.example.WuyeGuanli.vo.BasicRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class FeeController {

    @Autowired
    private FeeInfoService feeInfoService;

    // 用來新增資料的 POST 方法
    @PostMapping("/fee/add")
    public BasicRes saveFeeInfo(@RequestBody FeeInfo feeInfo) {
        // 呼叫 Service 層保存 FeeInfo 資料
    	feeInfo.setModifyingDate(LocalDateTime.now());  // 這裡設置時間
    	
        boolean isSaved = feeInfoService.saveFeeInfo(feeInfo);
        
        if (isSaved) {
            return new BasicRes(200, "資料新增成功");//之後改enum
        } else {
            return new BasicRes(400, "資料新增失敗");
        }
    }

    // 用來獲取所有資料的 GET 方法
    @GetMapping("/fee/getall")
    public List<FeeInfo> getAll() {
        return feeInfoService.getAllFeeInfo();
    }
}
