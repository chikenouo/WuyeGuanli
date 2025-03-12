package com.example.WuyeGuanli.service.ifs;

import com.example.WuyeGuanli.entity.ResidentLoginInfo;
import com.example.WuyeGuanli.entity.User;

public interface ResidentLoginService {
    ResidentLoginInfo login(User user);
    User findByIdentityNumber(String identityNumber); // 新增方法
}
