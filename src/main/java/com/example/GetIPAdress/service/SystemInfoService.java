package com.example.GetIPAdress.service;
import com.example.GetIPAdress.model.SystemInfo;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

@Service
public class SystemInfoService {

    public SystemInfo getSystemInfo() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] macArray = network.getHardwareAddress();
            StringBuilder mac = new StringBuilder();
            for (int i = 0; i < macArray.length; i++) {
                mac.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
            }
            return new SystemInfo(ip.getHostAddress(), mac.toString());
        } catch (UnknownHostException | SocketException e) {
            return new SystemInfo("Unable to get IP address", "Unable to get MAC address");
        }
    }
}
