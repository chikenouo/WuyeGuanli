package com.example.WuyeGuanli.controller;

import com.example.WuyeGuanli.service.ifs.DashBoardService;
import com.example.WuyeGuanli.vo.DashBoardSearchRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboards")
@CrossOrigin(origins = "http://localhost:4201")
public class DashBoardServiceController {

    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping(value = "/getAll", produces = "application/json")
    public DashBoardSearchRes getAll() {
        return dashBoardService.getAll();
    }
}
