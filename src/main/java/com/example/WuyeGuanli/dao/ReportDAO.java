package com.example.WuyeGuanli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.WuyeGuanli.dto.RepairDTO;
import com.example.WuyeGuanli.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportDAO extends BaseMapper<Report> {
    @Select("""
                SELECT location, description, COUNT(*) AS count
                FROM report
                GROUP BY location, description
                ORDER BY count DESC
                LIMIT 3
            """)
    List<RepairDTO> findTop3MostReported();
}
