package com.example.GetIPAdress.model;
public class SystemInfoDTO {
    private String ip;
    private String mac;

    public SystemInfoDTO(String ip, String mac) {
        this.ip = ip;
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}

