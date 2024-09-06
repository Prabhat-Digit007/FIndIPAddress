package com.example.GetIPAdress.service;

import com.example.GetIPAdress.entity.SystemInfo;
import com.example.GetIPAdress.model.SystemInfoDTO;
import com.example.GetIPAdress.repository.ISystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

@Service
public class SystemInfoService {

    @Autowired
    ISystemInfoRepository systemInfoRepository;

    public SystemInfoDTO getSystemInfo() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] macArray = network.getHardwareAddress();
            StringBuilder mac = new StringBuilder();
            for (int i = 0; i < macArray.length; i++) {
                mac.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
            }

            // Initialize the systemInfo object
            SystemInfo systemInfo = new SystemInfo();
            systemInfo.setIp(ip.getHostAddress());
            systemInfo.setMac(mac.toString());
            systemInfo = systemInfoRepository.save(systemInfo);

            return new SystemInfoDTO(ip.getHostAddress(), mac.toString());
        } catch (UnknownHostException | SocketException e) {
            return new SystemInfoDTO("Unable to get IP address", "Unable to get MAC address");
        }
    }
}
