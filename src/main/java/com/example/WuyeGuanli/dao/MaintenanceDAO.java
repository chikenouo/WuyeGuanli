package com.example.WuyeGuanli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.WuyeGuanli.dto.MaintenanceStatDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

// 這邊繼承什麼小我還沒搞清楚 :D
@Mapper
public interface MaintenanceDAO extends BaseMapper<com.example.WuyeGuanli.entity.MaintenanceEntity> {
    @Select("""
                SELECT location, floor, description, COUNT(*) AS count
                FROM maintenance
                GROUP BY location, floor, description
                ORDER BY count DESC
                LIMIT 5
            """)
    List<MaintenanceStatDTO> findTop3MostReportedIssues();
}
