package com.example.WuyeGuanli.service.ifs;

import com.example.WuyeGuanli.dto.MaintenanceStatDTO;

import java.util.List;

public interface MaintenanceService {
    List<MaintenanceStatDTO> getTop3MostReportedIssues();
}
