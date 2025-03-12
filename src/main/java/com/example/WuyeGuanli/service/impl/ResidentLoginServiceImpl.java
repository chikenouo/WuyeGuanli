package com.example.WuyeGuanli.service.impl;

import com.example.WuyeGuanli.dao.ResidentLoginDao;
import com.example.WuyeGuanli.entity.ResidentLoginInfo;
import com.example.WuyeGuanli.entity.Role;
import com.example.WuyeGuanli.entity.User;
import com.example.WuyeGuanli.service.ifs.ResidentLoginService;
import com.example.WuyeGuanli.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResidentLoginServiceImpl implements ResidentLoginService {
    @Autowired
    private ResidentLoginDao residentLoginDao;

    @Override
    public ResidentLoginInfo login(User user) {
        // 查詢用戶
        User result = residentLoginDao.selectByUsernameAndPassword(user);
        if (result == null) {
            return null;
        }

        // 檢查房客是否仍在居住（僅對 tenant 角色）
        if (result.getRole() == Role.tenant && !result.getIsCurrentlyResiding()) {
            return null; // 房客已搬離，不允許登入
        }

        // 生成 JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", result.getId());
        claims.put("identityNumber", result.getIdentityNumber());
        String jwt = JwtUtils.generateToken(claims);
        return new ResidentLoginInfo(result.getId(), result.getIdentityNumber(), result.getName(), jwt);
    }

    @Override
    public User findByIdentityNumber(String identityNumber) {
        return residentLoginDao.selectByIdentityNumber(identityNumber);
    }
}
