package com.example.WuyeGuanli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "maintenance")
public class MaintenanceEntity {
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "description")
    private String description;

    @Column(name = "photo1")
    private String photo1;

    @Column(name = "photo2")
    private String photo2;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "process_time")
    private LocalDateTime processTime;

    @Column(name = "status")
    private String status;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "is_repaired")
    private Integer isRepaired;
}
