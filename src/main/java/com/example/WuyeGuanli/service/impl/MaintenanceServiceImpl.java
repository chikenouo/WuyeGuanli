package com.example.WuyeGuanli.service.impl;

import com.example.WuyeGuanli.dao.MaintenanceDAO;
import com.example.WuyeGuanli.dto.MaintenanceStatDTO;
import com.example.WuyeGuanli.service.ifs.MaintenanceService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceDAO maintenanceDAO;

    @Override
    public List<MaintenanceStatDTO> getTop3MostReportedIssues() {
        return maintenanceDAO.findTop3MostReportedIssues();
    }
}
