package com.example.WuyeGuanli.controller;

import com.example.WuyeGuanli.service.ifs.RuleService;
import com.example.WuyeGuanli.vo.RuleSearchRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin(origins = "http://localhost:4201")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @GetMapping("/getAll")
    public RuleSearchRes getAll() {
        return ruleService.getAll();
    }
}
