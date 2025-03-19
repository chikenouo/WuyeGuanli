package com.example.WuyeGuanli.dto;

import lombok.Data;

@Data
public class MaintenanceStatDTO {
    private String location;
    private Integer floor;
    private String description;
    private Long count; // 統計數量
}

