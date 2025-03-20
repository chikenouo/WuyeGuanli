package com.example.WuyeGuanli.dto;

import lombok.Data;

@Data
public class RepairDTO {
    private String location;
    private String description;
    private Long count; // 統計數量
}
