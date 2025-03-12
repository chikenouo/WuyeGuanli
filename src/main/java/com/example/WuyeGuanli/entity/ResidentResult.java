package com.example.WuyeGuanli.entity;

import lombok.Data;

// 用戶介面統一回傳結果
@Data
public class ResidentResult {
    private Integer code; // 1成功，0為失敗
    private String msg; //錯誤信息
    private Object data; //數據

    public static ResidentResult success() {
        ResidentResult result = new ResidentResult();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static ResidentResult success(Object object) {
        ResidentResult result = new ResidentResult();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static ResidentResult error(String msg) {
        ResidentResult result = new ResidentResult();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
