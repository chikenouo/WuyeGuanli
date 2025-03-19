package com.example.WuyeGuanli.controller;

import com.example.WuyeGuanli.dto.MaintenanceStatDTO;
import com.example.WuyeGuanli.service.ifs.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@CrossOrigin(origins = "http://localhost:4201")
public class MaintenanceController {
    @Autowired
    private  MaintenanceService maintenanceService;

    @GetMapping("/top3")
    public List<MaintenanceStatDTO> getTop3MostReportedIssues() {
        return maintenanceService.getTop3MostReportedIssues();
    }
}
