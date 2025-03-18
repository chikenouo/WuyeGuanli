package com.example.WuyeGuanli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentLoginInfo {
    private Long id;
    private String address;
    private String name;
    private String token;
}
