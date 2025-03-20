package com.example.WuyeGuanli.service.ifs;

import com.example.WuyeGuanli.dto.RepairDTO;

import java.util.List;

public interface ReportService {
    List<RepairDTO> findTop3MostReported();
}
