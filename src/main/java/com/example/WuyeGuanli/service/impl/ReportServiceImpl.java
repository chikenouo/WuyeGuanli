package com.example.WuyeGuanli.service.impl;

import com.example.WuyeGuanli.dao.ReportDAO;
import com.example.WuyeGuanli.dto.RepairDTO;
import com.example.WuyeGuanli.service.ifs.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Override
    public List<RepairDTO> findTop3MostReported() {
        return reportDAO.findTop3MostReported();
    }
}
