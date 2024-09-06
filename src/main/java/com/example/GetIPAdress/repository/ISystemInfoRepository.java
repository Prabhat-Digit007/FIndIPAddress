package com.example.GetIPAdress.repository;

import com.example.GetIPAdress.entity.SystemInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISystemInfoRepository extends JpaRepository<SystemInfo,Long> {
}
