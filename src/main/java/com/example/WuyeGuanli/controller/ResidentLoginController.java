package com.example.WuyeGuanli.controller;

import com.example.WuyeGuanli.entity.ResidentLoginInfo;
import com.example.WuyeGuanli.entity.ResidentResult;
import com.example.WuyeGuanli.entity.Role;
import com.example.WuyeGuanli.entity.User;
import com.example.WuyeGuanli.service.ifs.ResidentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResidentLoginController {
    @Autowired
    private ResidentLoginService residentLoginService;

    @PostMapping(value = "/residentLogin", consumes = "application/json", produces = "application/json")
    public ResidentResult login(@RequestBody User user) {
        ResidentLoginInfo loginInfo = residentLoginService.login(user);
        if (loginInfo != null) {
            return ResidentResult.success(loginInfo);
        }

        // 進一步檢查錯誤原因
        User existingUser = residentLoginService.findByIdentityNumber(user.getIdentityNumber());
        if (existingUser == null) {
            return ResidentResult.error("帳號不存在");
        }
        if (existingUser.getRole() == Role.tenant && !existingUser.getIsCurrentlyResiding()) {
            return ResidentResult.error("帳號已停用");
        }
        return ResidentResult.error("密碼錯誤");
    }
}
