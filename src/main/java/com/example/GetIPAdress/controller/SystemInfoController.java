package com.example.GetIPAdress.controller;

import com.example.GetIPAdress.model.SystemInfoDTO;
import com.example.GetIPAdress.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @GetMapping("/system-info")
    public SystemInfoDTO getSystemInfo() {
        return systemInfoService.getSystemInfo();
    }
}
